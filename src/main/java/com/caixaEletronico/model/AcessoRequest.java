package com.caixaEletronico.model;

public class AcessoRequest {
	
	private String acesso;

	public AcessoRequest() {} 

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	public AcessoRequest(String acesso) {
		super();
		this.acesso = acesso;
	}
	
}
