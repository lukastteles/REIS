package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
	public void excluiMedicaoBalanca(MedicaoBalancaDomain medicao){
		Session novaSessao = SessaoAtual();
		Transaction tx = SessaoAtual().beginTransaction();
		novaSessao.delete(medicao);
		novaSessao.flush();
		tx.commit();
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
	
	@SuppressWarnings("unchecked")
	public MedicaoBalancaDomain listaUltimaMedicaoDoPaciente(int idPaciente){
		List<MedicaoBalancaDomain> listamedicoes =
				(List<MedicaoBalancaDomain>)SessaoAtual().createQuery(
						"from MedicaoBalancaDomain order by data where  paciente.id =" + idPaciente).list();
		
		SessaoAtual().close();
		return listamedicoes.get(0);
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
