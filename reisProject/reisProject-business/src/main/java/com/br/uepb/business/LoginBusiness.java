package com.br.uepb.business;

import com.br.uepb.dao.LoginDAO;
import com.br.uepb.model.LoginDomain;
import com.br.uepb.model.PacienteDomain;

public class LoginBusiness {
	
	private LoginDAO loginDAO = new LoginDAO();
	
	public boolean salvar(LoginDomain loginDomain){
		
		if(!loginDAO.jaExisteUsuario(loginDomain.getLogin())){
			loginDAO.salvaLogin(loginDomain);
			return true;
		}
		return false;
	}
	
	public boolean loginValido(String login, String senha){
		LoginDomain loginDomain = loginDAO.obtemLogin(login, senha);
		if(loginDomain!=null){
			SessaoBusiness.setLoginDomain(loginDomain);
			return true;
		}
		return false;
	}
}
