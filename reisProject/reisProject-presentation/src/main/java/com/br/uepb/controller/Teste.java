package com.br.uepb.controller;

import com.br.uepb.business.MedicoesBusiness;
import com.br.uepb.model.MedicaoBalancaDomain;

public class Teste {

	public static void main(String[] args) {
		MedicoesBusiness med = new MedicoesBusiness();
		MedicaoBalancaDomain bal =  med.lisatUltimaMedicaoBalanca(4);
		System.out.println(bal.getAltura()+", " + bal.getMassa());
	}
}
