package com.br.uepb.business;

import com.br.uepb.dao.LoginDAO;
import com.br.uepb.model.LoginDomain;

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
			//loginDAO.obtemLogin();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
