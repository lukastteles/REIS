package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Session;

import com.br.uepb.model.LoginDomain;
import com.br.uepb.model.PacienteDomain;

import conexaoBD.HibernateUtil;

public class LoginDAO {
	
	private Session sessaoAtual;
	
	public LoginDAO(){
		
	}
	
	/**
	 * Salva ou atualiza login
	 * @param login Sem o ID: Salvar, com ID: atualiza
	 */
	public void salvaLogin(LoginDomain login){
		SessaoAtual().beginTransaction();
		if(ehNovoUsuario(login)){
			SessaoAtual().save(login);
		}
		else{
			SessaoAtual().update(login);
		}
		SessaoAtual().getTransaction().commit();
		SessaoAtual().close();
	}
	
	public void excluiLogin(LoginDomain login){
		SessaoAtual().delete(login);
		SessaoAtual().close();
	}
	
	public LoginDomain obtemLogin(int idLogin){
		LoginDomain login = (LoginDomain)SessaoAtual().get(LoginDomain.class, idLogin);
		SessaoAtual().close();
		return login;
	}
	
	public LoginDomain obtemLogin(String usuario, String senha){
		LoginDomain login = (LoginDomain)SessaoAtual().createQuery("from LoginDomain"
				+ " where login ='" + usuario + "' AND senha ='" + senha + "'").list().get(0);
		
		return login;
	}
	
	public boolean jaExisteUsuario(String usuario){
		LoginDomain login = (LoginDomain)SessaoAtual().createQuery("from LoginDomain"
				+ " where login ='" + usuario + "'").list().get(0);
		if(login == null) return false;
		else return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<LoginDomain> listaLogins(){
		
		List<LoginDomain> logins = 
				(List<LoginDomain>)SessaoAtual().createQuery("from LoginDomain").list();
		
		SessaoAtual().close();
		return logins;
	}
	
	private Session SessaoAtual(){
		if (sessaoAtual == null || !sessaoAtual.isOpen()){
			sessaoAtual = HibernateUtil.getSessionFactory().openSession();
		}
		return sessaoAtual;
	}
	
	private boolean ehNovoUsuario(LoginDomain login){
		if(login.getId() > 0){
			return false;
		}
		else{
			return true;
		}
	}

}
