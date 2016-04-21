package com.br.uepb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class PacienteDomain {
	
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
	
	@ManyToOne
	@JoinColumn(name = "perfil_id")
	private PerfilDomain perfil;

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

	public PerfilDomain getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDomain perfil) {
		this.perfil = perfil;
	}
	

}
