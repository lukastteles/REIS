package com.br.uepb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "medicao_pressao")
public class MedicaoPressaoDomain {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id", referencedColumnName="id")
	@Fetch(FetchMode.JOIN)	
	private PacienteDomain paciente;
	
	@Column(name = "pressao_sistolica")
	private double pressaoSistolica;
	
	@Column(name = "pressao_diastolica")
	private double pressaoDiastolica;
	
	@Column(name = "pressao_media")
	private double pressaoMedia;
	
	@Column(name = "taxa_pulso")
	private double taxaDePulso;
	
	@Column(name="data_hora")
	private Date dataHora;
	
	@Column(name="u_pressao_sis")
	private String uPressaoSistolica;
	
	@Column(name="u_pressao_dias")
	private String uPressaoDiastolica;
	
	@Column(name="u_pressao_media")
	private String uPressaoMedia;
	
	@Column(name="u_taxa_pulso")
	private String uTaxaDePulso;
	
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
	public PacienteDomain getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteDomain paciente) {
		this.paciente = paciente;
	}
	public double getPressaoDiastolica() {
		return pressaoDiastolica;
	}
	public void setPressaoDiastolica(double pressaoDiastolica) {
		this.pressaoDiastolica = pressaoDiastolica;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getUnidadePressaoSistolica() {
		return uPressaoSistolica;
	}
	public void setUnidadePressaoSistolica(String unidadeMedida) {
		this.uPressaoSistolica = unidadeMedida;
	}
	public String getUnidadePressaoDiastolica() {
		return uPressaoDiastolica;
	}
	public void setUnidadePressaoDiastolica(String uPressaoDiastolica) {
		this.uPressaoDiastolica = uPressaoDiastolica;
	}
	public String getUnidadePressaoMedia() {
		return uPressaoMedia;
	}
	public void setUnidadePressaoMedia(String uPressaoMedia) {
		this.uPressaoMedia = uPressaoMedia;
	}
	public String getuTaxaDePulso() {
		return uTaxaDePulso;
	}
	public void setUnidadeTaxaDePulso(String uTaxaDePulso) {
		this.uTaxaDePulso = uTaxaDePulso;
	}
	
	public double getPressaoDistolica(){
		return this.pressaoDiastolica;
	}
	
	public void setPressaoDistolica(double pressao) {
		this.pressaoDiastolica = pressao;
		
	}
	
	
	
}
