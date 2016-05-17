package com.br.uepb.xml;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.model.MedicaoPressaoDomain;

public class Medicoes {
	private DataList _dataList = null;
	private ArrayList<Pair<String,String>> medicoes;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
	
	public Medicoes(DataList dataList) {
		_dataList = dataList;
	}
	
	public ArrayList<Pair<String,String>> getMedicoes() {
		medicoes = new ArrayList<Pair<String,String>>();
		//Pair<String,String> node = new Pair<String, String>(null, null);
		
		for (Entry entry : _dataList.getEntries()) {
			//Imprime a lista de meta de cada entidade
			getMeta(entry.getMeta());
			
			for(Entry sub : entry.getEntries()){
				getMeta(sub.getMeta());
				
				if(sub.getName().equals("Basic-Nu-Observed-Value")) {
					basic_nu(sub);
				}
				
				if(sub.getName().equals("Simple-Nu-Observed-Value")) {
					simple_nu(sub);
				}
				
				if ((sub.getName().equals("Compound-Basic-Nu-Observed-Value")) || (sub.getName().equals("Compound-Simple-Nu-Observed-Value"))) {
					compound_nu(sub);
				}
				
				if (sub.getName().equals("Absolute-Time-Stamp")) {
					absolute_time_stamp(sub);
				}
			}			
		}

		return medicoes;
	}
	
	private void getMeta(Map<String, String> meta) {
		
		for (Map.Entry<String, String> e : meta.entrySet()) {
			Pair<String,String> node = new Pair<String, String>(null, null);
			node.setFirst(e.getKey());
			node.setSecond(e.getValue());
			//System.out.println(node.getFirst()+" "+node.getSecond());
			medicoes.add(node);			
		}
	}
	
	private void basic_nu(Entry sub) {
		Pair<String,String> node = new Pair<String, String>(null, null);
		node.setFirst("value");
		node.setSecond(sub.getValue());
		//System.out.println(node.getFirst()+" "+node.getSecond());
		medicoes.add(node);		
	}

	private void simple_nu(Entry sub) {
		Pair<String,String> node = new Pair<String, String>(null, null);
		node.setFirst("value");
		node.setSecond(sub.getValue());
		//System.out.println(node.getFirst()+" "+node.getSecond());
		medicoes.add(node);		
	}
	
	private void compound_nu(Entry sub) {
		Pair<String,String> node = new Pair<String, String>(null, null);
		String values = "(";
		String metricId = "";
		
		for(Entry sub_entries : sub.getEntries()){
			//getMeta(sub_entries.getMeta());
			if (values.length() > 1) {
				values += "|";
			}
			//Obtem os valores tipo "meta-data"
			metricId = sub_entries.getMeta().get("metric-id"); 
			values += "metric-id=" + metricId;
			
			if (values.length() > 1) {
				values += "|";
			}
			
			values += "value=" + sub_entries.getValue();
	    }
		
		values += ")";
		node.setFirst("compound");
		node.setSecond(values);
		//System.out.println(node.getFirst()+" "+node.getSecond());
		medicoes.add(node);			   
	}
	
	private void absolute_time_stamp(Entry sub) {
		String[] names = new String[] {"century", "year", "month", "day", "hour", "minute", "second", "sec_fractions"};
		String[] times = new String[names.length];
		
	    for(int i = 0; i < names.length; i++) {
	        times[i] = sub.getEntries_map().get(names[i]).getValue();
	    }
	    
	    //formatação da data
	    String ano = format(times[0], 2)+format(times[1], 2);
	    String dia = format(times[3], 2);
	    String mes = format(times[2], 2);
	    String hora = format(times[4], 2);
	    String min = format(times[5], 2);
	    String seg = format(times[6], 2);
	    String milseg = format(times[7], 3);
		String data = dia+"/"+mes+"/"+ano+" "+hora+":"+min+":"+seg+":"+milseg;
				
		Pair<String,String> node = new Pair<String, String>(null, null);
		node.setFirst("dateTime");
		node.setSecond(data);
		//System.out.println(node.getFirst()+" "+node.getSecond());
		medicoes.add(node);		
	}	
	
	private String format(String value, int tamanho) {
		String name = value.trim();
		
		if (value.length() < tamanho) {
			name = "";
			for (int i=0; i< (tamanho-value.length()); i++) {
				name += "0";
			}
			name += value;
		}
		return name;
	}	

	public MedicaoOximetroDomain medicaoOximetro(ArrayList<Pair<String,String>> arrayMedicao) {
		MedicaoOximetroDomain oximetro = new MedicaoOximetroDomain();				
		Pair<String, String> medicao;
		int j = 0;
		
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();			
		
		for (int i = 0; i < arrayMedicao.size(); i++) {
			medicao = arrayMedicao.get(i);
			
			//lê o primeiro elemento do Oximeto
			if (medicao.getFirst().equals("HANDLE")) {
				i++;
				medicao = arrayMedicao.get(i);				
				String metricId = "";
				String unit_cod = ""; 		
				String unit = "";
				float value = 0;

				j = i;
				while ((!medicao.getFirst().equals("HANDLE")) && (j < arrayMedicao.size())) {
					System.out.println(medicao.getFirst() + " " + medicao.getSecond());
					
					if (medicao.getFirst().equals("metric-id")) {
						metricId = medicao.getSecond();
					}
					
					if (medicao.getFirst().equals("unit-code")) {
						unit_cod = medicao.getSecond();
					}
					
					if (medicao.getFirst().equals("unit")) {
						unit = medicao.getSecond();
					}
					
					if (medicao.getFirst().equals("value")) {
						value = Float.parseFloat(medicao.getSecond());
					}
					
					if (medicao.getFirst().equals("dateTime")) {		
						try {
							data = (Date) formatter.parse(medicao.getSecond());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						//data = medicao.getSecond();
					}
					j++;
					if (j < arrayMedicao.size()) {
						medicao = arrayMedicao.get(j);
					}
				}
				j--;
				i=j;
				
				if (metricId.equals("19384")) { //spo2
					oximetro.setSpo2(value);
					oximetro.setuSPO2(unit);
				}
				
				if (metricId.equals("18458")) { //pulse rate
					oximetro.setTaxaPulso(value);
					oximetro.setuTaxaDePulso(unit);
				}
			}
		}
		
		oximetro.setDataHora(data);	
		return oximetro;
	}

	public MedicaoBalancaDomain medicaoBalanca(ArrayList<Pair<String,String>> arrayMedicao) {
		MedicaoBalancaDomain balanca = new MedicaoBalancaDomain();				
		Pair<String, String> medicao;
		int j = 0;

		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		
		for (int i = 0; i < arrayMedicao.size(); i++) {
			medicao = arrayMedicao.get(i);
			
			//lê o primeiro elemento do Oximeto
			if (medicao.getFirst().equals("HANDLE")) {
				i++;
				medicao = arrayMedicao.get(i);				
				String metricId = "";
				String unit_cod = ""; 		
				String unit = "";
				float value = 0;
				
				j = i;
				while ((!medicao.getFirst().equals("HANDLE")) && (j < arrayMedicao.size())) {
					System.out.println(medicao.getFirst() + " " + medicao.getSecond());
					
					if (medicao.getFirst().equals("metric-id")) {
						metricId = medicao.getSecond();
					}
					
					if (medicao.getFirst().equals("unit-code")) {
						unit_cod = medicao.getSecond();
					}
					
					if (medicao.getFirst().equals("unit")) {
						unit = medicao.getSecond();
					}
					
					if (medicao.getFirst().equals("value")) {
						value = Float.parseFloat(medicao.getSecond());
					}
					
					if (medicao.getFirst().equals("dateTime")) {		
						try {
							data = (Date) formatter.parse(medicao.getSecond());
							System.out.println("Data formatada: "+data.toString());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						//data = medicao.getSecond();
					}
					
					j++;
					if (j < arrayMedicao.size()) {
						medicao = arrayMedicao.get(j);
					}
				}
				j--;
				i=j;
				
				if (metricId.equals("57664")) { //Body Weight
					balanca.setPeso(value);
					balanca.setuPeso(unit);
				}
				
				if (metricId.equals("57668")) { //Body height 
					balanca.setAltura(value);
					balanca.setuAltura(unit);
				}
				
				if (metricId.equals("57680")) { //Body Mass
					balanca.setMassa(value);
					balanca.setuMassa(unit);
				}
				
			}
		}
		balanca.setDataHora(data);
		return balanca;
	}

	public MedicaoPressaoDomain medicaoPressao(ArrayList<Pair<String, String>> med) {
		MedicaoPressaoDomain pressao = new MedicaoPressaoDomain();
		
		//fazer
		
		return pressao;
	}
}
