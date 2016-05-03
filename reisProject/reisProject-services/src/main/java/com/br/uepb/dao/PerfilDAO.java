package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Session;

import com.br.uepb.model.PacienteDomain;

import conexaoBD.HibernateUtil;

public class PerfilDAO {
	
	private Session sessaoAtual;
	
	public PerfilDAO(){
		
	}
	
	/**
	 * Salva ou atualiza perfil
	 * @param perfil Sem o ID: Salvar, com ID: atualiza
	 */
	public void salvaPaciente(PacienteDomain perfil){
		SessaoAtual().beginTransaction();
		if(ehNovoUsuario(perfil)){
			SessaoAtual().save(perfil);
		}
		else{
			SessaoAtual().update(perfil);
		}
		SessaoAtual().getTransaction().commit();
		SessaoAtual().close();
	}
	
	public void excluiPerfil(PacienteDomain paciente){
		SessaoAtual().delete(paciente);
		SessaoAtual().close();
	}
	
	public PacienteDomain obtemPaciente(int idPaciente){
		PacienteDomain perfil = (PacienteDomain)SessaoAtual().get(PacienteDomain.class, idPaciente);
		SessaoAtual().close();
		return perfil;
	}
	
	@SuppressWarnings("unchecked")
	public List<PacienteDomain> listaPerfis(){
		
		List<PacienteDomain> paciente = 
				(List<PacienteDomain>)SessaoAtual().createQuery("from PerfilDomain").list();
		
		SessaoAtual().close();
		return paciente;
	}
	
	private Session SessaoAtual(){
		if (sessaoAtual == null || !sessaoAtual.isOpen()){
			sessaoAtual = HibernateUtil.getSessionFactory().openSession();
		}
		return sessaoAtual;
	}
	
	private boolean ehNovoUsuario(PacienteDomain perfil){
		if(perfil.getId() > 0){
			return false;
		}
		else{
			return true;
		}
	}

}
