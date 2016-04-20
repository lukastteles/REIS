package com.br.uepb.model;

public class MedicaoOximetroDomain {
	
	private int id;
	private double spo2;
	private double taxa_pulso;
	private int paciente_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSpo2() {
		return spo2;
	}
	public void setSpo2(double spo2) {
		this.spo2 = spo2;
	}
	public double getTaxa_pulso() {
		return taxa_pulso;
	}
	public void setTaxa_pulso(double taxa_pulso) {
		this.taxa_pulso = taxa_pulso;
	}
	public int getPaciente_id() {
		return paciente_id;
	}
	public void setPaciente_id(int paciente_id) {
		this.paciente_id = paciente_id;
	}
	
	
}
