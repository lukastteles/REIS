package com.br.uepb.comunicacao;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servidor {
 
   public static void main(String[] args) throws IOException {
     // inicia o servidor
     new Servidor(12345).executa();
   }
   
   private int porta;
   private List<PrintStream> clientes;
   
   public Servidor (int porta) {
     this.porta = porta;
     this.clientes = new ArrayList<PrintStream>();
   }
   
   public void executa () throws IOException {
	   ServerSocket servidor = new ServerSocket(345);
	     System.out.println("Porta 12345 aberta!");
	     
	     Socket cliente = servidor.accept();
	     System.out.println("Nova conexão com o cliente " +   
	       cliente.getInetAddress().getHostAddress());
	     
	     Scanner entrada = new Scanner(cliente.getInputStream());
	     while (entrada.hasNextLine()) {
	       System.out.println(entrada.nextLine());
	     }
	     
	     entrada.close();
	     servidor.close();
   }
 }