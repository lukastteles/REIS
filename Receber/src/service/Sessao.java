package service;

import domain.Mensagem;

public class Sessao {
	
	/*public static String mensagem;

	public static String getMensagem() {
		return mensagem;
	}

	public static void setMensagem(String mensagem) {
		Sessao.mensagem = mensagem;
	}*/

	private static Mensagem mensagem;

	public static Mensagem getMensagem() {
		return mensagem;
	}

	public static void setMensagem(Mensagem mensagem) {
		Sessao.mensagem = mensagem;
	}
	
	
}
