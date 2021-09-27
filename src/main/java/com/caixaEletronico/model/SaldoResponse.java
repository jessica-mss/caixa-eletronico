package com.caixaEletronico.model;

public class SaldoResponse {
    private Float saldoConta;

    public SaldoResponse(Float saldoConta) {
        this.saldoConta = saldoConta;
    }

    public Float getSaldo() {
        return saldoConta;
    }

    public void setSaldo(Float saldoConta) {
        this.saldoConta = saldoConta;
    }
}