package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Session;

import com.br.uepb.model.MedicaoBalancaDomain;

import conexaoBD.HibernateUtil;

public class MedicaoBalancaDAO {
	
	private Session sessaoAtual;
	
	public void salvaMedicaoBalanca(MedicaoBalancaDomain medicao){
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
	public void excluiPerfil(MedicaoBalancaDomain medicao){
		SessaoAtual().delete(medicao);
		SessaoAtual().close();
	}
	
	public MedicaoBalancaDomain obtemMedicaoBalanca(int idBalanca){
		MedicaoBalancaDomain medicao = (MedicaoBalancaDomain)SessaoAtual().get(MedicaoBalancaDomain.class, idBalanca);
		SessaoAtual().close();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicaoBalancaDomain> listaMedicoes(){
		
		List<MedicaoBalancaDomain> medicao = 
				(List<MedicaoBalancaDomain>)SessaoAtual().createQuery("from MedicaoBalancaDomain").list();
		
		SessaoAtual().close();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicaoBalancaDomain> listaMedicoesDoPaciente(int idPaciente){
		List<MedicaoBalancaDomain> medicao =
				(List<MedicaoBalancaDomain>)SessaoAtual().createQuery(
						"from MedicaoBalancaDomain where  paciente.id =" + idPaciente).list();
		
		SessaoAtual().close();
		return medicao;
	}
	
	private Session SessaoAtual(){
		if (sessaoAtual == null || !sessaoAtual.isOpen()){
			sessaoAtual = HibernateUtil.getSessionFactory().openSession();
		}
		return sessaoAtual;
	}
	
	private boolean ehNovoUsuario(MedicaoBalancaDomain medicao){
		if(medicao.getId() > 0){
			return false;
		}
		else{
			return true;
		}
	}
	
}
