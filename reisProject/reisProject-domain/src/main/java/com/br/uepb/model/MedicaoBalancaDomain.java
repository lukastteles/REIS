package com.br.uepb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="medicao_balanca")
public class MedicaoBalancaDomain {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id", referencedColumnName="id")
	@Fetch(FetchMode.JOIN)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private PacienteDomain paciente;
	
	@Column(name="peso")
	private double peso;
	
	@Column(name="altura")
	private double altura;
	
	@Column(name="massa")
	private double massa;
	
	@Column(name="data_hora")
	private Date dataHora;
	
	@Column(name="u_peso")
	private double uPeso;
	
	@Column(name="u_altura")
	private double uAltura;
	
	@Column(name="u_massa")
	private double uMassa;
	
	public PacienteDomain getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteDomain paciente) {
		this.paciente = paciente;
	}
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
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public double getuPeso() {
		return uPeso;
	}
	public void setuPeso(double uPeso) {
		this.uPeso = uPeso;
	}
	public double getuAltura() {
		return uAltura;
	}
	public void setuAltura(double uAltura) {
		this.uAltura = uAltura;
	}
	public double getuMassa() {
		return uMassa;
	}
	public void setuMassa(double uMassa) {
		this.uMassa = uMassa;
	}
	
}
