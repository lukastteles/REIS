package com.br.uepb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.business.GerenciarSessaoBusiness;
import com.br.uepb.business.MedicoesBusiness;
import com.br.uepb.business.SessaoBusiness;
import com.br.uepb.comunicacao.ClienteREIS;
import com.br.uepb.comunicacao.ServidorREIS;
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
		
		MedicoesBusiness medicoes = new MedicoesBusiness();
		
		List<MedicaoBalancaDomain> listaBalanca = medicoes.listaMedicoesBalancaPaciente(sessao.getLoginDomain().getPaciente().getId());
		List<MedicaoOximetroDomain> listaOximetro = medicoes.listaMedicoesOximetroPaciente(sessao.getLoginDomain().getPaciente().getId());
		List<MedicaoPressaoDomain> listaPressao = medicoes.listaMedicoesPressaoPaciente(sessao.getLoginDomain().getPaciente().getId());
		
		
		modelAndView.addObject("listaBalanca", listaBalanca);
		modelAndView.addObject("listaOximetro", listaOximetro);
		modelAndView.addObject("listaPressao", listaPressao);
		
		modelAndView.addObject("cliente", new ClienteREIS());
		
		modelAndView.setViewName("home/hl7");
		modelAndView.addObject("usuario", sessao.getLoginDomain().getPaciente().getNome());
		
		return modelAndView;
	}

	@RequestMapping(value="/home/hl7.html", method = RequestMethod.POST)
	public ModelAndView enviarMensagemPost(@ModelAttribute("cliente") ClienteREIS cliente, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		ClienteREIS socket = new ClienteREIS();
		
		try {
			socket.enviarMensagem(cliente.getIp(), cliente.getPorta(), cliente.getMensagem());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modelAndView;		
	}

}
