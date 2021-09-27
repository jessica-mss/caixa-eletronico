package com.caixaEletronico.model;

public class ClienteRequest {
	private String Acesso;
	private String nomeCliente;
	private String telefoneCliente;
	public String getNomeCliente() {
		return nomeCliente;
	}
	public String getAcesso() {
		return Acesso;
	}
	public void setAcesso(String acesso) {
		Acesso = acesso;
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

	public ClienteRequest(){}

	public ClienteRequest(String acesso, String nomeCliente, String telefoneCliente) {
		super();
		Acesso = acesso;
		this.nomeCliente = nomeCliente;
		this.telefoneCliente = telefoneCliente;
	}
}
