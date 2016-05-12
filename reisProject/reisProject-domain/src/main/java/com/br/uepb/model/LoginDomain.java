package com.br.uepb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "login")
public class LoginDomain {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "login")
	@NotNull
	private String login;
	
	@Column(name = "senha")
	@NotNull
	private String senha;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paciente_id", referencedColumnName="id")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private PacienteDomain paciente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public PacienteDomain getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteDomain paciente) {
		this.paciente = paciente;
	}
	
}
