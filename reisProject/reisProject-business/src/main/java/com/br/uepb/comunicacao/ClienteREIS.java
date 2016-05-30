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
		 Socket cliente = new Socket("192.168.1.72", 345);
	     System.out.println("O cliente se conectou ao servidor!");
	     
	     Scanner teclado = new Scanner(System.in);
	     PrintStream saida = new PrintStream(cliente.getOutputStream());
	     
	     while (teclado.hasNextLine()) {
	       saida.println(teclado.nextLine());
	     }
	     
	     saida.close();
	     teclado.close();		
	}
	
}	
