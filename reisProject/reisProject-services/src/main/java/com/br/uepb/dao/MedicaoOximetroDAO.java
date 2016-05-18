package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Session;

import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.MedicaoOximetroDomain;

import conexaoBD.HibernateUtil;

public class MedicaoOximetroDAO {

	private Session sessaoAtual;
	
	public void salvaMedicaoOximetro(MedicaoOximetroDomain medicao){
		SessaoAtual().beginTransaction();
		if(ehNovoUsuario(medicao)){
			SessaoAtual().save(medicao);
		}
		else{
			SessaoAtual().update(medicao);
		}
		SessaoAtual().getTransaction().commit();
		SessaoAtual().close();
	}
	public void excluiPerfil(MedicaoOximetroDomain medicao){
		SessaoAtual().delete(medicao);
		SessaoAtual().close();
	}
	
	public MedicaoOximetroDomain obtemMedicaoOximetro(int idOximetro){
		MedicaoOximetroDomain medicao = (MedicaoOximetroDomain)SessaoAtual().get(MedicaoOximetroDomain.class, idOximetro);
		SessaoAtual().close();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicaoOximetroDomain> listaMedicoes(){
		
		List<MedicaoOximetroDomain> medicao = 
				(List<MedicaoOximetroDomain>)SessaoAtual().createQuery("from MedicaoOximetroDomain").list();
		
		SessaoAtual().close();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicaoOximetroDomain> listaMedicoesDoPaciente(int idPaciente){
		List<MedicaoOximetroDomain> medicao =
				(List<MedicaoOximetroDomain>)SessaoAtual().createQuery(
						"from MedicaoOximetroDomain where  paciente.id =" + idPaciente).list();
		
		SessaoAtual().close();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public MedicaoOximetroDomain listaUltimaMedicaoDoPaciente(int idPaciente){
		List<MedicaoOximetroDomain> listamedicoes =
				(List<MedicaoOximetroDomain>)SessaoAtual().createQuery(
						"from MedicaoOximetroDomain order by data where  paciente.id =" + idPaciente).list();
		
		SessaoAtual().close();
		return listamedicoes.get(0);
	}
	
	private Session SessaoAtual(){
		if (sessaoAtual == null || !sessaoAtual.isOpen()){
			sessaoAtual = HibernateUtil.getSessionFactory().openSession();
		}
		return sessaoAtual;
	}
	
	private boolean ehNovoUsuario(MedicaoOximetroDomain medicao){
		if(medicao.getId() > 0){
			return false;
		}
		else{
			return true;
		}
	}
	
}
