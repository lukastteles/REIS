package com.br.uepb.business;

import com.br.uepb.model.LoginDomain;

public class SessaoBusiness {
	private static LoginDomain loginDomain = null;

	public LoginDomain getLoginDomain() {
		return loginDomain;
	}

	public void setLoginDomain(LoginDomain loginDomain) {
		SessaoBusiness.loginDomain = loginDomain;
	}
	
}
