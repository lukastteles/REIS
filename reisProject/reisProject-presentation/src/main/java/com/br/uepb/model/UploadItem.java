package com.br.uepb.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadItem {

	private String name;
	private CommonsMultipartFile fileData;
	private String tipo_dispositivo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	public String getTipo_dispositivo() {
		return tipo_dispositivo;
	}

	public void setTipo_dispositivo(String tipo_dispositivo) {
		this.tipo_dispositivo = tipo_dispositivo;
	}

}