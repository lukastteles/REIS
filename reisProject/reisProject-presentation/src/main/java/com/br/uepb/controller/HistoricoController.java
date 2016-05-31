package com.br.uepb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.business.GerenciarSessaoBusiness;
import com.br.uepb.business.MedicoesBusiness;
import com.br.uepb.business.SessaoBusiness;
import com.br.uepb.model.*;

@Controller
public class HistoricoController {

	public List<HistoricoDomain> historico;
	
	@RequestMapping(value = "/home/historico.html", method = RequestMethod.GET)
	public ModelAndView historicoGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		MedicoesBusiness medicoesBusiness = new MedicoesBusiness();
		
		String login = request.getSession().getAttribute("login").toString();
		SessaoBusiness sessao = GerenciarSessaoBusiness.getSessaoBusiness(login);
		if(sessao == null){
			modelAndView.setViewName("redirect:/index/login.html");
			return modelAndView;
		}
		
		
		//HistoricoDomain ultimoHistorico = preencherHistorico();
		List<MedicaoOximetroDomain> historicoOximetro = medicoesBusiness.listaMedicoesOximetroPaciente(sessao.getLoginDomain().getPaciente().getId());
		List<MedicaoBalancaDomain> historicoBalanca = medicoesBusiness.listaMedicoesBalancaPaciente(sessao.getLoginDomain().getPaciente().getId());
		List<MedicaoPressaoDomain> historicoPressao = medicoesBusiness.listaMedicoesPressaoPaciente(sessao.getLoginDomain().getPaciente().getId());
		
		MedicaoBalancaDomain med = new MedicaoBalancaDomain();
		
		
		modelAndView.setViewName("home/historico");
		modelAndView.addObject("usuario", login);
		modelAndView.addObject("historicoOximetro", historicoOximetro);
		modelAndView.addObject("historicoBalanca", historicoBalanca);
		modelAndView.addObject("historicoPressao", historicoPressao);
		
		return modelAndView;
	}
	
	public HistoricoDomain preencherHistorico(){
		MedicaoBalancaDomain balanca = new MedicaoBalancaDomain();
		MedicaoOximetroDomain oximetro = new MedicaoOximetroDomain();
		MedicaoPressaoDomain pressao = new MedicaoPressaoDomain();
		
		balanca.setMassa(75);
		balanca.setAltura(177);
		balanca.setuMassa("Kg");
		
		oximetro.setSpo2(105);
		oximetro.setTaxaPulso(80);
		oximetro.setuSPO2("%");
		
		pressao.setPressaoDiastolica(72);
		pressao.setPressaoDistolica(80);
		pressao.setPressaoMedia(79);
		pressao.setPressaoSistolica(75);
		
		
		HistoricoDomain ultimoHistorico = new HistoricoDomain(9, "11/05/2016", "14:00", balanca, oximetro, pressao);
		return ultimoHistorico;
	}

}
