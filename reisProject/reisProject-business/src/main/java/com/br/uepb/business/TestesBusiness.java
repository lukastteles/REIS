package com.br.uepb.business;

import com.br.uepb.model.LoginDomain;

public class TestesBusiness {

	public static void main(String[] args) {
		//Verifica se salva as medicoes
		MedicoesBusiness medicoesBusines = new MedicoesBusiness();
		
		/*
		PacienteDomain paciente = new PacienteDomain();
		//paciente.setId(1);
		paciente.setNome("luana janaina");
		paciente.setSexo("feminino");
		paciente.setCidade("Cidade");
		paciente.setEndereco("Endereco");
		paciente.setTelefoneCasa("88888888");
		
		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.salvaPaciente(paciente);
		
		LoginDomain login = new LoginDomain();
		login.setLogin("luana");
		login.setSenha("123");
		login.setPaciente(paciente);		
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.salvaLogin(login);
		*/
		
		LoginDomain login = new LoginDomain();
		login.setLogin("luana");
		login.setSenha("123");
		SessaoBusiness.setLoginDomain(login);
		
		String xml = "C:/Users/Luana/workspace/Leitura_XML/arquivos_xml/Oximetro XML de medicoes1.xml";		
		medicoesBusines.medicaoOximetro(xml);
		System.out.println("Leitura Oximetro");
		
		xml = "C:/Users/Luana/workspace/Leitura_XML/arquivos_xml/Balança XML de medicoes.xml";		
		medicoesBusines.medicaoBalanca(xml);
		System.out.println("Leitura Balanca");

	}

}
