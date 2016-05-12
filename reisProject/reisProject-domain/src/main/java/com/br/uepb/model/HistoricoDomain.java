package com.br.uepb.model;

public class HistoricoDomain {

	private int id;
	private String data;
	private String hora;
	private MedicaoBalancaDomain balanca;
	private MedicaoOximetroDomain oximetro;
	private MedicaoPressaoDomain pressao;

	public HistoricoDomain(int id, String data, String hora, MedicaoBalancaDomain balanca,
			MedicaoOximetroDomain oximetro, MedicaoPressaoDomain pressao) {
		
		this.id = id;
		this.data = data;
		this.balanca = balanca;
		this.oximetro = oximetro;
		this.pressao = pressao;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public MedicaoBalancaDomain getBalanca() {
		return balanca;
	}

	public void setBalanca(MedicaoBalancaDomain balanca) {
		this.balanca = balanca;
	}

	public MedicaoOximetroDomain getOximetro() {
		return oximetro;
	}

	public void setOximetro(MedicaoOximetroDomain oximetro) {
		this.oximetro = oximetro;
	}

	public MedicaoPressaoDomain getPressao() {
		return pressao;
	}

	public void setPressao(MedicaoPressaoDomain pressao) {
		this.pressao = pressao;
	}

}
