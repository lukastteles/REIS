package com.br.uepb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.model.LoginDomain;

@Controller
public class CadastroController {

	@RequestMapping(value = "/index/cadastrar.html", method = RequestMethod.GET)
	public ModelAndView cadastrarGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cadastrar");
		return modelAndView;
	}

	@RequestMapping(value = "/index/cadastrar.html", method = RequestMethod.POST)
	public ModelAndView cadastrarPost(@ModelAttribute("login") LoginDomain login, Model model) {

		System.out.println(login.getLogin());
		System.out.println(login.getSenha());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cadastrar");
		return modelAndView;
	}

}
