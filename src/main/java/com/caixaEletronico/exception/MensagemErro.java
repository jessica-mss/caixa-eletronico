package com.caixaEletronico.exception;

public class MensagemErro {
    private String mensagem;

	public MensagemErro(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMessage() {
		return mensagem;
	}

	public void setMessage(String mensagem) {
		this.mensagem = mensagem;
	}
}