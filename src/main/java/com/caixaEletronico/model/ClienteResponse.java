package com.caixaEletronico.model;

public class ClienteResponse {
	private String codigoBanco;
	private String nomeBanco;
	private String conta;
	private String nomeCliente;
	private String telefoneCliente;

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	public ClienteResponse(String codigoBanco, String nomeBanco, String conta, String nomeCliente, String telefoneCliente) {
		super();
		this.codigoBanco = codigoBanco;
		this.nomeBanco = nomeBanco;
		this.conta = conta;
		this.nomeCliente = nomeCliente;
		this.telefoneCliente = telefoneCliente;
	}

}
