package com.br.uepb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/home/home.html", method = RequestMethod.GET)
	public ModelAndView homeGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		modelAndView.addObject("usuario", "fulano");
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/perfil.html", method = RequestMethod.GET)
	public ModelAndView perfilGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("perfil");
		modelAndView.addObject("usuario", "fulano");
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/medicao.html", method = RequestMethod.GET)
	public ModelAndView medicaoGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("medicao");
		modelAndView.addObject("usuario", "fulano");
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/historico.html", method = RequestMethod.GET)
	public ModelAndView historicoGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("historico");
		modelAndView.addObject("usuario", "fulano");
		return modelAndView;
	}
	

}
