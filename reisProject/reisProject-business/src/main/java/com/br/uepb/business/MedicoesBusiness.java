package com.br.uepb.business;

import java.util.ArrayList;
import java.util.List;

import com.br.uepb.dao.LoginDAO;
import com.br.uepb.dao.MedicaoBalancaDAO;
import com.br.uepb.dao.MedicaoOximetroDAO;
import com.br.uepb.dao.MedicaoPressaoDAO;
import com.br.uepb.model.LoginDomain;
import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.model.MedicaoPressaoDomain;
import com.br.uepb.model.PacienteDomain;
import com.br.uepb.xml.DataList;
import com.br.uepb.xml.Medicoes;
import com.br.uepb.xml.Pair;

public class MedicoesBusiness {

	private MedicaoBalancaDAO medicaoBalancaDAO = new MedicaoBalancaDAO();
	private MedicaoOximetroDAO medicaoOximetroDAO = new MedicaoOximetroDAO();
	private MedicaoPressaoDAO medicaoPressaoDAO = new MedicaoPressaoDAO();
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDomain loginDomain;
	
	////////////////////////////////////OXIMETRO///////////////////////////////////////////
	public Boolean medicaoOximetro(String pathXML) {
		
		try {
			DataList dataList = new DataList(pathXML);
			Medicoes medicoes = new Medicoes(dataList);
			//Metodo para gerar um ArrayList de Par;
			ArrayList<Pair<String,String>> med = medicoes.getMedicoes();
			
			MedicaoOximetroDomain medicaoOximetroDomain =  medicoes.medicaoOximetro(med);
			loginDomain = SessaoBusiness.getLoginDomain();//loginDAO.obtemLogin(SessaoBusiness.getLoginDomain().getLogin(), SessaoBusiness.getLoginDomain().getSenha());			
			PacienteDomain paciente = loginDomain.getPaciente();			
			medicaoOximetroDomain.setPaciente(paciente);			
			medicaoOximetroDAO.salvaMedicaoOximetro(medicaoOximetroDomain);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public List<MedicaoOximetroDomain> listaMedicoesOximetroPaciente(int idPaciente){
		return  medicaoOximetroDAO.listaMedicoesDoPaciente(idPaciente);
	}
	
	public MedicaoOximetroDomain lisatUltimaMedicaoOximetro(int idPaciente){
		return medicaoOximetroDAO.obtemUltimaMedicao(idPaciente);
	}
	
	////////////////////////////////////BALANCA///////////////////////////////////////////
	
	public Boolean medicaoBalanca(String pathXML) {
		
		try {
			DataList dataList = new DataList(pathXML);
			Medicoes medicoes = new Medicoes(dataList);
			//Metodo para gerar um ArrayList de Par;
			ArrayList<Pair<String,String>> med = medicoes.getMedicoes();
			
			MedicaoBalancaDomain medicaoBalancaDomain =  medicoes.medicaoBalanca(med);
			loginDomain = SessaoBusiness.getLoginDomain();//loginDAO.obtemLogin(SessaoBusiness.getLoginDomain().getLogin(), SessaoBusiness.getLoginDomain().getSenha());				
			PacienteDomain paciente = loginDomain.getPaciente();			
			medicaoBalancaDomain.setPaciente(paciente);								
			medicaoBalancaDAO.salvaMedicaoBalanca(medicaoBalancaDomain);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public List<MedicaoBalancaDomain> listaMedicoesBalancaPaciente(int idPaciente){
		return  medicaoBalancaDAO.listaMedicoesDoPaciente(idPaciente);
	}
	
	public MedicaoBalancaDomain lisatUltimaMedicaoBalanca(int idPaciente){
		return medicaoBalancaDAO.obtemUltimaMedicao(idPaciente);
	}
	
////////////////////////////////////MEDIDOR DE PRESSAO///////////////////////////////////////////
	
	public Boolean medicaoPressao(String pathXML) {
		
		try {
			DataList dataList = new DataList(pathXML);
			Medicoes medicoes = new Medicoes(dataList);
			//Metodo para gerar um ArrayList de Par;
			ArrayList<Pair<String,String>> med = medicoes.getMedicoes();
			
			MedicaoPressaoDomain medicaoPressaoDomain =  medicoes.medicaoPressao(med);
			loginDomain = SessaoBusiness.getLoginDomain();//loginDAO.obtemLogin(SessaoBusiness.getLoginDomain().getLogin(), SessaoBusiness.getLoginDomain().getSenha());				
			PacienteDomain paciente = loginDomain.getPaciente();			
			medicaoPressaoDomain.setPaciente(paciente);								
			medicaoPressaoDAO.salvaMedicaoPressao(medicaoPressaoDomain);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public List<MedicaoPressaoDomain> listaMedicoesPressaoPaciente(int idPaciente){
		return  medicaoPressaoDAO.listaMedicoesDoPaciente(idPaciente);
	}
	
	public MedicaoPressaoDomain lisatUltimaMedicaoPressao(int idPaciente){
		return medicaoPressaoDAO.obtemUltimaMedicao(idPaciente);
	}	
	
}
