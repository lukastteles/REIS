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
@Table(name="medicao_oximetro")
public class MedicaoOximetroDomain {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id", referencedColumnName="id")
	@Fetch(FetchMode.JOIN)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private PacienteDomain paciente;
	
	@Column(name = "spo2")
	private double spo2;
	
	@Column(name = "taxa_pulso")
	private double taxaPulso;
	
	@Column(name="data_hora")
	private Date dataHora;
	
	@Column(name="u_spo2")
	private String uSPO2;
	
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
	public double getSpo2() {
		return spo2;
	}
	public void setSpo2(double spo2) {
		this.spo2 = spo2;
	}
	public PacienteDomain getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteDomain paciente) {
		this.paciente = paciente;
	}
	public double getTaxaPulso() {
		return taxaPulso;
	}
	public void setTaxaPulso(double taxaPulso) {
		this.taxaPulso = taxaPulso;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getuSPO2() {
		return uSPO2;
	}
	public void setuSPO2(String uSPO2) {
		this.uSPO2 = uSPO2;
	}
	public String getuTaxaDePulso() {
		return uTaxaDePulso;
	}
	public void setuTaxaDePulso(String uTaxaDePulso) {
		this.uTaxaDePulso = uTaxaDePulso;
	}
	
	
}
