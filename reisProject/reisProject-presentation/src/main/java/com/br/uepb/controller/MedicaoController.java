package com.br.uepb.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.br.uepb.business.MedicoesBusiness;
import com.br.uepb.business.SessaoBusiness;
import com.br.uepb.model.UploadItem;

@Controller
public class MedicaoController {

	MedicoesBusiness medicoesBusiness = new MedicoesBusiness();

	@RequestMapping(value = "/home/medicao.html", method = RequestMethod.GET)
	public ModelAndView medicaoGet(Model model) {

		ModelAndView modelAndView = new ModelAndView();

		if (SessaoBusiness.getLoginDomain() == null) {
			modelAndView.setViewName("redirect:/index/login.html");
			return modelAndView;
		}
		UploadItem uploadItem = new UploadItem();
		model.addAttribute("uploadItem", uploadItem);

		modelAndView.setViewName("home/medicao");
		return modelAndView;
	}

	// POST: Do Upload
	@RequestMapping(value = "/home/medicao.html", method = RequestMethod.POST)
	public ModelAndView medicaoPost(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("uploadItem") UploadItem uploadItem) {

		ModelAndView modelAndView = new ModelAndView();
		String mensagem = "";
		String status = "";
		String description = uploadItem.getName();
		System.out.println("Description: " + description);

		String uploadRootPath = request.getRealPath(File.separator);
		System.out.println("uploadRootPath=" + uploadRootPath);

		File uploadRootDir = new File(uploadRootPath);
		//
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		CommonsMultipartFile fileData = uploadItem.getFileData();
		//

		// Client File Name
		String name = fileData.getOriginalFilename();
		System.out.println("Client File Name = " + name);

		if (name != null && name.length() > 0) {
			try {
				// Create the file on server
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(fileData.getBytes());
				stream.close();

				System.out.println("Write file: " + serverFile);
				// ate aqui salvou o arquivo xml
				String tipo_dispositivo = uploadItem.getTipo_dispositivo();
				String arquivo = serverFile.toString();

				if (tipo_dispositivo.equals("0")) { // oximetro
					if (medicoesBusiness.medicaoOximetro(arquivo)) {
						medicoesBusiness.medicaoOximetro(arquivo);
						mensagem = "Medição Oximetro cadastrada com sucesso!";
						status = "0";
					} else {
						mensagem = "Erro ao cadastrar Oximetro arquivo XML!";
						status = "1";
					}

				} else if (tipo_dispositivo.equals("1")) { // balanca
					if (medicoesBusiness.medicaoBalanca(arquivo)) {
						mensagem = "Medição Balança cadastrada com sucesso!";
						status = "0";
					} else {
						mensagem = "Erro ao cadastrar Balança arquivo XML!";
						status = "1";
					}

				} else if (tipo_dispositivo.equals("2")) { // pressao
					if (medicoesBusiness.medicaoPressao(arquivo)) {

						mensagem = "Medição Pressão cadastrada com sucesso!";
						status = "0";
					} else {
						mensagem = "Erro ao cadastrar Pressão arquivo XML!";
						status = "1";
					}

				} else {
					mensagem = "Erro ao cadastrar arquivo XML!";
					status = "1";
				}

			} catch (Exception e) {
				System.out.println("Error Write file: " + name);
				mensagem = "Erro ao cadastrar arquivo XML!";
				status = "1";
			}
		}
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("status", status);
		modelAndView.setViewName("home/medicao");
		return modelAndView;
	}

}
