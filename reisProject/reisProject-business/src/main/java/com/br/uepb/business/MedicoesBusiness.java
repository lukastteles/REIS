package com.br.uepb.business;

import java.util.ArrayList;

import javax.sound.sampled.DataLine;

import com.br.uepb.dao.MedicaoBalancaDAO;
import com.br.uepb.dao.MedicaoOximetroDAO;
import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.xml.DataList;
import com.br.uepb.xml.Medicoes;
import com.br.uepb.xml.Pair;

public class MedicoesBusiness {

	public Boolean medicaoOximetro(String pathXML) {
		
		try {
			DataList dataList = new DataList(pathXML);
			Medicoes medicoes = new Medicoes(dataList);
			//Metodo para gerar um ArrayList de Par;
			ArrayList<Pair<String,String>> med = medicoes.getMedicoes();
			
			MedicaoOximetroDomain medicaoOximetroDomain =  medicoes.medicaoOximetro(med);
			MedicaoOximetroDAO medicaoOximetroDAO = new MedicaoOximetroDAO();			
			medicaoOximetroDAO.salvaMedicaoOximetro(medicaoOximetroDomain);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public Boolean medicaoBalanca(String pathXML) {
		
		try {
			DataList dataList = new DataList(pathXML);
			Medicoes medicoes = new Medicoes(dataList);
			//Metodo para gerar um ArrayList de Par;
			ArrayList<Pair<String,String>> med = medicoes.getMedicoes();
			
			MedicaoBalancaDomain medicaoBalancaDomain =  medicoes.medicaoBalanca(med);
			MedicaoBalancaDAO medicaoBalancaDAO = new MedicaoBalancaDAO();			
			medicaoBalancaDAO.salvaMedicaoBalanca(medicaoBalancaDomain);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
}
