package com.caixaEletronico.model;

public class SaqueResponse {
	private Banco banco;
	private String conta;
	private int qtdCedulas2;
	private int qtdCedulas5;
	private int qtdCedulas10;
	private int qtdCedulas50;
	
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
	public int getQtdCedulas2() {
		return qtdCedulas2;
	}
	public void setQtdCedulas2(int qtdCedulas2) {
		this.qtdCedulas2 = qtdCedulas2;
	}
	public int getQtdCedulas5() {
		return qtdCedulas5;
	}
	public void setQtdCedulas5(int qtdCedulas5) {
		this.qtdCedulas5 = qtdCedulas5;
	}
	public int getQtdCedulas10() {
		return qtdCedulas10;
	}
	public void setQtdCedulas10(int qtdCedulas10) {
		this.qtdCedulas10 = qtdCedulas10;
	}
	public int getQtdCedulas50() {
		return qtdCedulas50;
	}
	public void setQtdCedulas50(int qtdCedulas50) {
		this.qtdCedulas50 = qtdCedulas50;
	}
	public SaqueResponse(Banco banco, String conta, int qtdCedulas2, int qtdCedulas5, int qtdCedulas10,
			int qtdCedulas50) {
		super();
		this.banco = banco;
		this.conta = conta;
		this.qtdCedulas2 = qtdCedulas2;
		this.qtdCedulas5 = qtdCedulas5;
		this.qtdCedulas10 = qtdCedulas10;
		this.qtdCedulas50 = qtdCedulas50;
	}
	
}
