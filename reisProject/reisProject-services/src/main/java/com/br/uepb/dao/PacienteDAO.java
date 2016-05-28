package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.br.uepb.model.LoginDomain;
import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.model.MedicaoPressaoDomain;
import com.br.uepb.model.PacienteDomain;

import conexaoBD.HibernateUtil;

public class PacienteDAO {
	
private Session sessaoAtual;
	
	public PacienteDAO(){
		
	}
	
	/**
	 * Salva ou atualiza paciente
	 * @param paciente Sem o ID: Salvar, com ID: atualiza
	 */
	public void salvaPaciente(PacienteDomain paciente){
		SessaoAtual().beginTransaction();
		if(ehNovoPaciente(paciente)){
			SessaoAtual().save(paciente);
		}
		else{
			SessaoAtual().update(paciente);
		}
		SessaoAtual().getTransaction().commit();
		SessaoAtual().close();
	}
	
	public void excluiPaciente(PacienteDomain paciente){
		Session novaSessao = SessaoAtual();
		LoginDAO loginDAO = new LoginDAO();
		MedicaoOximetroDAO medicaoOxDAO = new MedicaoOximetroDAO();
		MedicaoPressaoDAO medicaoPres = new MedicaoPressaoDAO();
		MedicaoBalancaDAO medicaoB = new MedicaoBalancaDAO();
		LoginDomain login = loginDAO.obtemLoginPorPaciente(paciente.getId());		
		
		Transaction tx = SessaoAtual().beginTransaction();
		if(login != null){
		novaSessao.delete(login);
		}
		for (MedicaoOximetroDomain medicao  : medicaoOxDAO.listaMedicoesDoPaciente(paciente.getId())) {
			novaSessao.delete(medicao);
		}
		for(MedicaoPressaoDomain medicao : medicaoPres.listaMedicoesDoPaciente(paciente.getId())){
			novaSessao.delete(medicao);
		}
		for(MedicaoBalancaDomain medicao : medicaoB.listaMedicoesDoPaciente(paciente.getId())){
			novaSessao.delete(medicao);
		}
		novaSessao.delete(paciente);
		novaSessao.flush();
		tx.commit();
	}
	
	public PacienteDomain obtemPaciente(int idPaciente){
		PacienteDomain paciente = (PacienteDomain)SessaoAtual().get(PacienteDomain.class, idPaciente);
		SessaoAtual().close();
		return paciente;
	}
	
	public PacienteDomain obtemUltimoPacienteCadastrado(){
		Query query = SessaoAtual().createQuery("FROM PacienteDomain ORDER BY id DESC").setMaxResults(1);
		PacienteDomain paciente = (PacienteDomain)query.uniqueResult();
		SessaoAtual().close();
		return paciente;
	}
	
	@SuppressWarnings("unchecked")
	public List<PacienteDomain> listaPacientes(){
		
		List<PacienteDomain> pacientes = 
				(List<PacienteDomain>)SessaoAtual().createQuery("from PacienteDomain").list();
		
		
		SessaoAtual().close();
		return pacientes;
	}
	
	private Session SessaoAtual(){
		if (sessaoAtual == null || !sessaoAtual.isOpen()){
			sessaoAtual = HibernateUtil.getSessionFactory().openSession();
		}
		return sessaoAtual;
	}
	
	private boolean ehNovoPaciente(PacienteDomain paciente){
		if(paciente.getId() > 0){
			return false;
		}
		else{
			return true;
		}
	}

}
