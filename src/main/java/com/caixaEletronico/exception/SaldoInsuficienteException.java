package com.caixaEletronico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException() {
        super("SALDO INSUFICIENTE");
    }

    public SaldoInsuficienteException(String message) {
        super(message);
    }
}