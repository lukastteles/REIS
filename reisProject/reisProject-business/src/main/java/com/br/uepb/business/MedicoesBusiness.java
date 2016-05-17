package com.br.uepb.business;

import java.util.ArrayList;

import javax.sound.sampled.DataLine;

import com.br.uepb.dao.LoginDAO;
import com.br.uepb.dao.MedicaoBalancaDAO;
import com.br.uepb.dao.MedicaoOximetroDAO;
import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.model.LoginDomain;
import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.model.PacienteDomain;
import com.br.uepb.xml.DataList;
import com.br.uepb.xml.Medicoes;
import com.br.uepb.xml.Pair;

public class MedicoesBusiness {

	private MedicaoBalancaDAO medicaoBalancaDAO = new MedicaoBalancaDAO();
	private MedicaoOximetroDAO medicaoOximetroDAO = new MedicaoOximetroDAO();
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDomain loginDomain;
	
	public Boolean medicaoOximetro(String pathXML) {
		
		try {
			DataList dataList = new DataList(pathXML);
			Medicoes medicoes = new Medicoes(dataList);
			//Metodo para gerar um ArrayList de Par;
			ArrayList<Pair<String,String>> med = medicoes.getMedicoes();
			
			MedicaoOximetroDomain medicaoOximetroDomain =  medicoes.medicaoOximetro(med);
			loginDomain = loginDAO.obtemLogin(SessaoBusiness.getLoginDomain().getLogin(), SessaoBusiness.getLoginDomain().getSenha());			
			PacienteDomain paciente = loginDomain.getPaciente();			
			medicaoOximetroDomain.setPaciente(paciente);			
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
			loginDomain = loginDAO.obtemLogin(SessaoBusiness.getLoginDomain().getLogin(), SessaoBusiness.getLoginDomain().getSenha());				
			PacienteDomain paciente = loginDomain.getPaciente();			
			medicaoBalancaDomain.setPaciente(paciente);								
			medicaoBalancaDAO.salvaMedicaoBalanca(medicaoBalancaDomain);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
}
