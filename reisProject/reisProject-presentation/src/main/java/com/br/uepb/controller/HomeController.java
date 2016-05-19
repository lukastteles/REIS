package com.br.uepb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.business.LoginBusiness;
import com.br.uepb.business.MedicoesBusiness;
import com.br.uepb.business.SessaoBusiness;
import com.br.uepb.model.LoginDomain;
import com.br.uepb.model.PacienteDomain;

@Controller
public class HomeController {
	
	

	@RequestMapping(value = "/home/home.html", method = RequestMethod.GET)
	public ModelAndView homeGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		
		if(SessaoBusiness.getLoginDomain()==null){
			modelAndView.setViewName("redirect:/index/login.html");
			return modelAndView;
		}
		MedicoesBusiness medicoesBusiness = new MedicoesBusiness();
		LoginDomain login = SessaoBusiness.getLoginDomain();
		modelAndView.setViewName("home/home");
		modelAndView.addObject("usuario", login.getPaciente().getNome());
		modelAndView.addObject("paciente", login.getPaciente());
		modelAndView.addObject("oximetro", medicoesBusiness.lisatUltimaMedicaoOximetro(login.getPaciente().getId()));
		modelAndView.addObject("balanca", medicoesBusiness.lisatUltimaMedicaoBalanca(login.getPaciente().getId()));
		modelAndView.addObject("pressao", medicoesBusiness.lisatUltimaMedicaoPressao(login.getPaciente().getId()));
		return modelAndView;
	}
	
	
	

}
