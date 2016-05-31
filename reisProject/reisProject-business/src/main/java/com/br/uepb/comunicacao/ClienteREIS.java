package com.br.uepb.comunicacao;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClienteREIS {

	private String ip;
	private int porta;
	private String mensagem; 
	
	public void enviarMensagem(String ip, int porta, String mensagem) throws Exception {
		 Socket cliente = new Socket(ip, porta);
	     System.out.println("O cliente se conectou ao servidor!");
	     PrintStream saida = new PrintStream(cliente.getOutputStream());
	     
	     saida.println(mensagem);
	     cliente.getInputStream();
	     saida.close();
	     
	}
	
	public void fecharConexao(Socket so) throws IOException {
		so.close();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}	
