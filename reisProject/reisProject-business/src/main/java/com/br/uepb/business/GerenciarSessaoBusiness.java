package com.br.uepb.business;

import java.util.HashMap;
import java.util.Map;

import com.br.uepb.model.LoginDomain;

public class GerenciarSessaoBusiness {
	
private static Map<String, SessaoBusiness> sessoes = new HashMap<>();
	
	public static SessaoBusiness getSessaoBusiness(String login){

		return sessoes.get(login);
	}
	
	/*public static SessaoBusiness getSessaoBusiness(int idLogin){
		return sessoes.get(loginDAO.obtemLogin(usuario, senha));
	}*/
	
	public static void addSessaoBusiness(LoginDomain login, SessaoBusiness sessao){
		if(!sessoes.containsKey(login.getLogin())){
			sessao.setLoginDomain(login);
			sessoes.put(login.getLogin(), sessao);
		}
	}
	
	public static void removeSessao(String login){
		try {
			sessoes.remove(login);
		} catch (Exception e) {
		}
	}

}
