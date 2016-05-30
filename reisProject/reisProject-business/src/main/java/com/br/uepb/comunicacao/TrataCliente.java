package com.br.uepb.comunicacao;

import java.io.InputStream;
import java.util.Scanner;

public class TrataCliente implements Runnable {
 
   private InputStream cliente;
   private Servidor servidor;
 
   public TrataCliente(InputStream cliente, Servidor servidor) {
     this.cliente = cliente;
     this.servidor = servidor;
   }
 
   public void run() {
     // quando chegar uma msg, distribui pra todos
     Scanner s = new Scanner(this.cliente);
     while (s.hasNextLine()) {
//       servidor.distribuiMensagem(s.nextLine());
     }
     s.close();
   }
 }