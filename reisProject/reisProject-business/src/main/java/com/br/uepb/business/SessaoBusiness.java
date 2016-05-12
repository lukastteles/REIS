package com.br.uepb.business;

import com.br.uepb.model.LoginDomain;

public class SessaoBusiness {
	private static LoginDomain loginDomain = null;

	public static LoginDomain getLoginDomain() {
		return loginDomain;
	}

	public static void setLoginDomain(LoginDomain loginDomain) {
		SessaoBusiness.loginDomain = loginDomain;
	}
	
}
