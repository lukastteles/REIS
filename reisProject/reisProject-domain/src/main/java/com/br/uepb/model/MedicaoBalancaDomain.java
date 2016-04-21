package com.br.uepb.model;

public class MedicaoBalancaDomain {
	
	private int id;
	private double peso;
	private double altura;
	private double massa;
	private int paciente_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getMassa() {
		return massa;
	}
	public void setMassa(double massa) {
		this.massa = massa;
	}
	public int getPaciente_id() {
		return paciente_id;
	}
	public void setPaciente_id(int paciente_id) {
		this.paciente_id = paciente_id;
	}
	
}
