package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.br.uepb.model.MedicaoBalancaDomain;
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
	
	public void excluiPressao(MedicaoPressaoDomain medicao){
		Query query = SessaoAtual().createQuery("DELETE MedicaoPressaoDomain WHERE id= :id");
		query.setParameter("id", medicao.getId());
		query.executeUpdate();
		SessaoAtual().close();
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
