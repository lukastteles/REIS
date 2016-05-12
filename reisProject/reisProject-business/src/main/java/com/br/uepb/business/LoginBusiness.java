package com.br.uepb.business;

import com.br.uepb.dao.LoginDAO;
import com.br.uepb.model.LoginDomain;
import com.br.uepb.model.PacienteDomain;

public class LoginBusiness {
	
	private LoginDAO loginDAO = new LoginDAO();
	
	public boolean salvar(LoginDomain loginDomain){
		try {
			loginDAO.salvaLogin(loginDomain);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean loginValido(String login, String senha){
		try {
			for (LoginDomain loginDomain : loginDAO.listaLogins()) {
				if(loginDomain.getLogin().equals(login) && loginDomain.getSenha().equals(senha)){
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;
	}
}
