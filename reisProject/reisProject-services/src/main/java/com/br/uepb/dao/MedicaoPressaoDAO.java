package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.uepb.model.MedicaoPressaoDomain;

import conexaoBD.HibernateUtil;

public class MedicaoPressaoDAO {

private Session sessaoAtual;
	
	public MedicaoPressaoDAO(){
		
	}
	
	/**
	 * Salva ou atualiza MedicaoPressao
	 * @param medicaoPressao Sem o ID: Salvar, com ID: atualiza
	 */
	public void salvaMedicaoPressao(MedicaoPressaoDomain medicaoPressao){
		SessaoAtual().beginTransaction();
		if(ehNovaMedicao(medicaoPressao)){
			SessaoAtual().save(medicaoPressao);
		}
		else{
			SessaoAtual().update(medicaoPressao);
		}
		SessaoAtual().getTransaction().commit();
		SessaoAtual().close();
	}
	
	public void excluiMedicaoPressao(MedicaoPressaoDomain medicao){
		Session novaSessao = SessaoAtual();
		Transaction tx = SessaoAtual().beginTransaction();
		novaSessao.delete(medicao);
		novaSessao.flush();
		tx.commit();
	}
	
	public MedicaoPressaoDomain obtemMedicaoPressao(int idMedicao){
		MedicaoPressaoDomain medicao = (MedicaoPressaoDomain)SessaoAtual().get(MedicaoPressaoDomain.class, idMedicao);
		SessaoAtual().close();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicaoPressaoDomain> listaMedicoesPressao(){
		
		List<MedicaoPressaoDomain> medicoes = 
				(List<MedicaoPressaoDomain>)SessaoAtual().createQuery("from MedicaoPressaoDomain").list();
		
		
		SessaoAtual().close();
		return medicoes;
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicaoPressaoDomain> listaMedicoesDoPaciente(int idPaciente){
		List<MedicaoPressaoDomain> medicao =
				(List<MedicaoPressaoDomain>)SessaoAtual().createQuery(
						"from MedicaoPressaoDomain where  paciente.id =" + idPaciente).list();
		
		SessaoAtual().close();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public MedicaoPressaoDomain listaUltimaMedicaoDoPaciente(int idPaciente){
		List<MedicaoPressaoDomain> listamedicoes =
				(List<MedicaoPressaoDomain>)SessaoAtual().createQuery(
						"from MedicaoPressaoDomain order by data where  paciente.id =" + idPaciente).list();
		
		SessaoAtual().close();
		return listamedicoes.get(0);
	}
	
	private Session SessaoAtual(){
		if (sessaoAtual == null || !sessaoAtual.isOpen()){
			sessaoAtual = HibernateUtil.getSessionFactory().openSession();
		}
		return sessaoAtual;
	}
	
	private boolean ehNovaMedicao(MedicaoPressaoDomain medicao){
		if(medicao.getId() > 0){
			return false;
		}
		else{
			return true;
		}
	}
}
