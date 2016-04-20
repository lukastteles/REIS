package com.br.uepb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = "/index/index.html", method = RequestMethod.GET)
	public ModelAndView indexGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		return modelAndView;
	}

	@RequestMapping(value = "/index/cadastrar.html", method = RequestMethod.GET)
	public ModelAndView cadastrarGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		return modelAndView;
	}

	@RequestMapping(value = "/index/login.html", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		return modelAndView;
	}

}
