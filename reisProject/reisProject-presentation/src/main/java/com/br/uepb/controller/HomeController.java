package com.br.uepb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.business.GerenciarSessaoBusiness;
import com.br.uepb.business.LoginBusiness;
import com.br.uepb.business.MedicoesBusiness;
import com.br.uepb.business.SessaoBusiness;
import com.br.uepb.model.LoginDomain;

@Controller
public class HomeController {
	
	

	@RequestMapping(value = "/home/home.html", method = RequestMethod.GET)
	public ModelAndView homeGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		String login = request.getSession().getAttribute("login").toString();
		SessaoBusiness sessao = GerenciarSessaoBusiness.getSessaoBusiness(login);
		if(sessao == null){
			modelAndView.setViewName("redirect:/index/login.html");
			return modelAndView;
		}
		MedicoesBusiness medicoesBusiness = new MedicoesBusiness();
		LoginBusiness loginBusiness = new LoginBusiness();
		LoginDomain loginDomain = sessao.getLoginDomain();
		loginDomain.setPaciente(loginBusiness.getPaciente(loginDomain.getLogin(), loginDomain.getSenha()));
		modelAndView.setViewName("home/home");
		modelAndView.addObject("usuario", loginDomain.getPaciente().getNome());
		modelAndView.addObject("paciente", loginDomain.getPaciente());
		modelAndView.addObject("oximetro", medicoesBusiness.lisatUltimaMedicaoOximetro(loginDomain.getPaciente().getId()));
		modelAndView.addObject("balanca", medicoesBusiness.lisatUltimaMedicaoBalanca(loginDomain.getPaciente().getId()));
		modelAndView.addObject("pressao", medicoesBusiness.lisatUltimaMedicaoPressao(loginDomain.getPaciente().getId()));
		return modelAndView;
	}
	
	
	

}
