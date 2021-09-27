package com.caixaEletronico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLogin {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUserLogin;
	
	private String login;
	
	private String senha;
	
	private int caixa;
	
	private String conta;

	public long getIdUserLogin() {
		return idUserLogin;
	}

	public void setIdUserLogin(long idUserLogin) {
		this.idUserLogin = idUserLogin;
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

	public int getCaixa() {
		return caixa;
	}

	public void setCaixa(int caixa) {
		this.caixa = caixa;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}
	

	
}


