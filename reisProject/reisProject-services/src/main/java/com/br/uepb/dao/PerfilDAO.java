package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Session;

import com.br.uepb.model.PerfilDomain;

import conexaoBD.HibernateUtil;

public class PerfilDAO {
	
	private Session sessaoAtual;
	
	public PerfilDAO(){
		
	}
	
	/**
	 * Salva ou atualiza perfil
	 * @param perfil Sem o ID: Salvar, com ID: atualiza
	 */
	public void salvaPerfil(PerfilDomain perfil){
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
	
	public void excluiPerfil(PerfilDomain perfil){
		SessaoAtual().delete(perfil);
		SessaoAtual().close();
	}
	
	public PerfilDomain obtemPerfil(int idPerfil){
		PerfilDomain perfil = (PerfilDomain)SessaoAtual().get(PerfilDomain.class, idPerfil);
		SessaoAtual().close();
		return perfil;
	}
	
	@SuppressWarnings("unchecked")
	public List<PerfilDomain> listaPerfis(){
		
		List<PerfilDomain> perfis = 
				(List<PerfilDomain>)SessaoAtual().createQuery("from PerfilDomain").list();
		
		
		SessaoAtual().close();
		return perfis;
	}
	
	private Session SessaoAtual(){
		if (sessaoAtual == null || !sessaoAtual.isOpen()){
			sessaoAtual = HibernateUtil.getSessionFactory().openSession();
		}
		return sessaoAtual;
	}
	
	private boolean ehNovoUsuario(PerfilDomain perfil){
		if(perfil.getId() > 0){
			return false;
		}
		else{
			return true;
		}
	}

}
