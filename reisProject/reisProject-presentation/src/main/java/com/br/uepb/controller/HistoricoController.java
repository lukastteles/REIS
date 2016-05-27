package com.br.uepb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.business.MedicoesBusiness;
import com.br.uepb.model.HistoricoDomain;
import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.model.MedicaoPressaoDomain;

@Controller
public class HistoricoController {

	public List<HistoricoDomain> historico;
	
	@RequestMapping(value = "/home/historico.html", method = RequestMethod.GET)
	public ModelAndView historicoGet(HttpServletRequest request) {

		
		ModelAndView modelAndView = new ModelAndView();
		
		
		HistoricoDomain ultimoHistorico = preencherHistorico();
		
		modelAndView.setViewName("home/historico");
		modelAndView.addObject("usuario", request.getAttribute("loginDomain"));
		modelAndView.addObject("ultimoHistorico", ultimoHistorico);
		
		System.out.println(ultimoHistorico.getData());
		return modelAndView;
	}
	
	public HistoricoDomain preencherHistorico(){
		MedicaoBalancaDomain balanca = new MedicaoBalancaDomain();
		MedicoesBusiness busBal = new MedicoesBusiness();
			balanca = busBal.lisatUltimaMedicaoBalanca(4);
		
		MedicaoOximetroDomain oximetro = new MedicaoOximetroDomain();
			oximetro = busBal.lisatUltimaMedicaoOximetro(4);
		MedicaoPressaoDomain pressao = new MedicaoPressaoDomain();
			pressao = busBal.lisatUltimaMedicaoPressao(4);		
		
		HistoricoDomain ultimoHistorico = new HistoricoDomain(9, "11/05/2016", "14:00", balanca, oximetro, pressao);
		return ultimoHistorico;
	}

}
