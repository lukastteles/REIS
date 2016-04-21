package com.br.uepb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class MedicaoPressaoDomain {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private PacienteDomain paciente;
	
	@Column(name = "pressao_sistolica")
	private double pressaoSistolica;
	
	@Column(name = "pressao_diastolica")
	private double pressaoDiastolica;
	
	@Column(name = "pressao_media")
	private double pressaoMedia;
	
	@Column(name = "taxa_pulso")
	private double taxaDePulso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PacienteDomain getId_Paciente() {
		return paciente;
	}
	public void setId_Paciente(PacienteDomain paciente) {
		this.paciente = paciente;
	}
	public double getPressaoSistolica() {
		return pressaoSistolica;
	}
	public void setPressaoSistolica(double pressaoSistolica) {
		this.pressaoSistolica = pressaoSistolica;
	}
	public double getPressaoDistolica() {
		return pressaoDiastolica;
	}
	public void setPressaoDistolica(double pressaoDistolica) {
		this.pressaoDiastolica = pressaoDistolica;
	}
	public double getPressaoMedia() {
		return pressaoMedia;
	}
	public void setPressaoMedia(double pressaoMedia) {
		this.pressaoMedia = pressaoMedia;
	}
	public double getTaxaDePulso() {
		return taxaDePulso;
	}
	public void setTaxaDePulso(double taxaDePulso) {
		this.taxaDePulso = taxaDePulso;
	}
	
	
}
