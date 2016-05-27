package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.uepb.model.LoginDomain;

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
		Session novaSessao = SessaoAtual();
		Transaction tx = SessaoAtual().beginTransaction();
		novaSessao.delete(login);
		novaSessao.flush();
		tx.commit();
	}
	
	public LoginDomain obtemLogin(int idLogin){
		LoginDomain login = (LoginDomain)SessaoAtual().get(LoginDomain.class, idLogin);
		SessaoAtual().close();
		return login;
	}
	
	public LoginDomain obtemLogin(String usuario, String senha){
		Query query = SessaoAtual().createQuery("FROM LoginDomain WHERE login = :usuario AND senha = :senha");
		query.setString("usuario", usuario);
		query.setString("senha", senha);
		LoginDomain login = (LoginDomain)query.uniqueResult();
		
		return login;
	}
	
	public LoginDomain obtemLoginPorPaciente(int idPaciente){
		
		Query query = SessaoAtual().createQuery("FROM LoginDomain WHERE paciente.id = :idPaciente");
		query.setParameter("idPaciente", idPaciente);
		LoginDomain login = (LoginDomain)query.uniqueResult();
		
		return login;
	}
	
	public boolean jaExisteUsuario(String usuario){
		Query query = SessaoAtual().createQuery("FROM LoginDomain WHERE login = :usuario");
		query.setString("usuario", usuario);
		return (query.uniqueResult() != null);
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
