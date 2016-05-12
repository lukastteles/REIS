package com.br.uepb.business;

import com.br.uepb.dao.MedicaoOximetroDAO;

public class TestesBusiness {

	public static void main(String[] args) {
		//Verifica se salva as medicoes
		MedicoesBusiness medicoesBusines = new MedicoesBusiness();
		
		String xml = "C:/Users/Luana/workspace/Leitura_XML/arquivos_xml/Oximetro XML de medicoes1.xml";		
		medicoesBusines.medicaoOximetro(xml);
		System.out.println("Leitura Oximetro");
		
		xml = "C:/Users/Luana/workspace/Leitura_XML/arquivos_xml/Balança XML de medicoes.xml";		
		medicoesBusines.medicaoBalanca(xml);
		System.out.println("Leitura Balanca");

	}

}
