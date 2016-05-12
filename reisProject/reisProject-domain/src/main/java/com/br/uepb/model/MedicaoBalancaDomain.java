package com.br.uepb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="medicao_balanca")
public class MedicaoBalancaDomain {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private PacienteDomain paciente;
	
	@Column(name="peso")
	private double peso;
	
	@Column(name="altura")
	private double altura;
	
	@Column(name="massa")
	private double massa;
	
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
	
}
