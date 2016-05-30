package com.br.uepb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.business.GerenciarSessaoBusiness;
import com.br.uepb.business.SessaoBusiness;
import com.br.uepb.model.*;

@Controller
public class Hl7Controller {

	public List<HistoricoDomain> historico;
	
	@RequestMapping(value = "/home/hl7.html", method = RequestMethod.GET)
	public ModelAndView hl7Get(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();		
		String login = request.getSession().getAttribute("login").toString();
		SessaoBusiness sessao = GerenciarSessaoBusiness.getSessaoBusiness(login);
		if(sessao == null){
			modelAndView.setViewName("redirect:/index/login.html");
			return modelAndView;
		}
						
		modelAndView.setViewName("home/hl7");
		modelAndView.addObject("usuario", sessao.getLoginDomain().getPaciente().getNome());
		
		return modelAndView;
	}


}
