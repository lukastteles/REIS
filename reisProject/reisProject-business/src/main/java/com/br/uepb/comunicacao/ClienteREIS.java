package com.br.uepb.comunicacao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteREIS {

	public static void main(String[] args) throws Exception {
		System.out.println("Iniciando cliente.");
		
		System.out.println("Iniciando conexao com o cliente");
		Scanner sc2 = new Scanner(System.in);
		System.out.print("Informe o IP: ");
		String ip = sc2.nextLine();
		
		Socket soket = new Socket(ip, 2525);
		
		System.out.println("Conexao estabelecida");
		
		InputStream input = soket.getInputStream();
		OutputStream output = soket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Digite a mensagem: ");
			
			String msg = sc.nextLine();
			out.println(msg);
			
			if ("FIM".equals(msg)) {
				break;
			}
			
			msg = in.readLine();
			System.out.println("Mensagem recebida pelo servidor: " + msg);
			
			in.close();
			out.close();
			
			soket.close();
			
			System.out.println("Conexao encerrada.");
		}
		
	}
	
}	
