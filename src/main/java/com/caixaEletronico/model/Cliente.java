package com.caixaEletronico.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idBanco")
	private Banco banco;
		
	@NotNull
	//@Size(min = 20)
	private String conta;
	
	@NotNull
	private float saldoConta;
	
	@NotNull
	private String nomeCliente;
	
	@NotNull
	private String login;
	
	@NotNull
	private String senha;
	
	private String telefoneCliente;
	
	private String acesso;
	
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataAcesso;

	
	//Getters & Setters
	public String getConta() {
		return conta;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public float getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(float saldoConta) {
		this.saldoConta = saldoConta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	public LocalDateTime getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(LocalDateTime dataAcesso) {
		this.dataAcesso = dataAcesso;
	}
		
}
