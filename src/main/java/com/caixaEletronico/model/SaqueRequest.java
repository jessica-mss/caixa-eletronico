package com.caixaEletronico.model;

public class SaqueRequest {
	private String acesso;
	private float valor;
	private int idCaixa; 
	
	public int getIdCaixa() {
		return idCaixa;
	}
	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	public String getAcesso() {
		return acesso;
	}
	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	public SaqueRequest(){}

	public SaqueRequest(String acesso, float valor, int idCaixa) {
		super();
		this.acesso = acesso;
		this.valor = valor;
		this.idCaixa = idCaixa;
	}
	
	
	
}
