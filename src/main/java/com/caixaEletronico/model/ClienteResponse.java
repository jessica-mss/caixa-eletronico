package com.caixaEletronico.model;

public class ClienteResponse {
	private Banco banco;
	private String conta;
	private String nomeCliente;
	private String telefoneCliente;
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
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
	public ClienteResponse(Banco banco, String conta, String nomeCliente, String telefoneCliente) {
		super();
		this.banco = banco;
		this.conta = conta;
		this.nomeCliente = nomeCliente;
		this.telefoneCliente = telefoneCliente;
	}

}
