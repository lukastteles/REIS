package com.br.uepb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.business.LoginBusiness;
import com.br.uepb.business.SessaoBusiness;
import com.br.uepb.model.LoginDomain;

@Controller
public class PerfilController {

	@RequestMapping(value = "/home/perfil.html", method = RequestMethod.GET)
	public ModelAndView acessarGet(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		if(SessaoBusiness.getLoginDomain()==null){
			modelAndView.setViewName("redirect:/index/login.html");
			return modelAndView;
		}
		modelAndView.setViewName("home/perfil");
		LoginDomain login1 = SessaoBusiness.getLoginDomain();
		modelAndView.addObject("loginDomain",
				SessaoBusiness.getLoginDomain());
		return modelAndView;
	}

	@RequestMapping(value = "/home/perfil.html", method = RequestMethod.POST)
	public ModelAndView alterarPost(@ModelAttribute("loginDomain") LoginDomain login, Model model) {
		LoginBusiness loginBusiness = new LoginBusiness();
		ModelAndView modelAndView = new ModelAndView();
		login.setLogin(SessaoBusiness.getLoginDomain().getLogin());
		login.setId(SessaoBusiness.getLoginDomain().getId());
			
		if(loginBusiness.atualizar(login)){

			modelAndView.setViewName("home/perfil");
			String mensagem = "Alterações realizadas com sucesso";
			modelAndView.addObject("mensagem", mensagem);
			modelAndView.addObject("status",
					"0");
		}else{
			modelAndView.setViewName("home/perfil");
			String mensagem = "Erro ao fazer alterações";
			modelAndView.addObject("mensagem", mensagem);
			modelAndView.addObject("status",
					"1");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/excluir.html", method = RequestMethod.POST)
	public ModelAndView excluirGet(@ModelAttribute("loginExcluir") LoginDomain login, Model model) {

		ModelAndView modelAndView = new ModelAndView();
		LoginBusiness loginBusiness = new LoginBusiness();
		if(loginBusiness.excluir(SessaoBusiness.getLoginDomain())){
			SessaoBusiness.setLoginDomain(null);
			modelAndView.setViewName("index/index");
			String mensagem = "Todas as suas informações foram removidas";
			modelAndView.addObject("mensagem", mensagem);
			modelAndView.addObject("statusExcluir",
					"0");
		}else{
			SessaoBusiness.setLoginDomain(null);
			modelAndView.setViewName("home/perfil");
			String mensagem = "Não foi possível excluir suas informações";
			modelAndView.addObject("mensagem", mensagem);
			modelAndView.addObject("statusExcluir",
					"1");
		}
		

		return modelAndView;
	}

}
