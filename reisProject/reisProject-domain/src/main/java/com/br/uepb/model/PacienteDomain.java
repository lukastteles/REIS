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
	
	@Column(name = "nome")
	@NotNull
	private String nome;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "telefone_casa")
	private String telefoneCasa;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefoneCasa() {
		return telefoneCasa;
	}

	public void setTelefoneCasa(String telefoneCasa) {
		this.telefoneCasa = telefoneCasa;
	}
	
	

}
