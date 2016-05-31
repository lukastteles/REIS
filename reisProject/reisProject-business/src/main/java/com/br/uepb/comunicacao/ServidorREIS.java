package com.br.uepb.comunicacao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorREIS {

	public void abrirAcesso(String ip, int porta) throws Exception {

		ServerSocket servidor = new ServerSocket(porta);
		Socket cliente = servidor.accept();

		InputStream input = cliente.getInputStream();
		OutputStream output = cliente.getOutputStream();

		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);

		while (true) {
			String mensagem = in.readLine();
			if (mensagem != null) {
				System.out.println(
						"Mensagem recebida do cliente: " 
						+ cliente.getInetAddress().getHostName() + ": " + mensagem);	
				if ("FIM".equals(mensagem)) {
					System.out.println("Pediu para encerrar a mensagem.");
					break;
				}
			}				
			out.println(mensagem + " asd ");

		}

		System.out.println("Encerada a conexao");

		in.close();
		out.close();
		cliente.close();
		System.err.println("Encerrada a conexao");

		servidor.close();
	}

}
