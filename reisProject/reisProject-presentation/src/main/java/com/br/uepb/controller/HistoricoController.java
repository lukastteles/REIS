package com.br.uepb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.model.*;

@Controller
public class HistoricoController {

	public List<HistoricoDomain> historico;
	
	@RequestMapping(value = "/home/historico.html", method = RequestMethod.GET)
	public ModelAndView historicoGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		
		
		
		HistoricoDomain ultimoHistorico = preencherHistorico();
		
		modelAndView.setViewName("historico");
		modelAndView.addObject("usuario", "Sidney");
		modelAndView.addObject("ultimoHistorico", ultimoHistorico);
		
		System.out.println(ultimoHistorico.getData());
		return modelAndView;
	}
	
	public HistoricoDomain preencherHistorico(){
		MedicaoBalancaDomain balanca = new MedicaoBalancaDomain();
		MedicaoOximetroDomain oximetro = new MedicaoOximetroDomain();
		MedicaoPressaoDomain pressao = new MedicaoPressaoDomain();
		
		balanca.setMassa(75);
		balanca.setAltura(177);
		balanca.setUnidadeMedida("Kg");
		
		oximetro.setSpo2(105);
		oximetro.setTaxaPulso(80);
		oximetro.setUnidadeMedida("%");
		
		pressao.setPressaoDiastolica(72);
		pressao.setPressaoDistolica(80);
		pressao.setPressaoMedia(79);
		pressao.setPressaoSistolica(75);
		
		
		HistoricoDomain ultimoHistorico = new HistoricoDomain(9, "11/05/2016", "14:00", balanca, oximetro, pressao);
		return ultimoHistorico;
	}

}
