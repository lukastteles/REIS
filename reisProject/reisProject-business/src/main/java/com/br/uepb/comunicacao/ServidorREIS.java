package com.br.uepb.comunicacao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorREIS {

	public static void main(String[] args) throws Exception {
		System.out.println("Iniciando servidor");

		ServerSocket servidor = new ServerSocket(2525);

		System.out.println("Aguardando conexao.");

		Socket cliente = servidor.accept();

		System.out.println("Conexão estabelecida com um cliente.");

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
