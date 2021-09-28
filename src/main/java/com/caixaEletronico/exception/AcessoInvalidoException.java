package com.caixaEletronico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AcessoInvalidoException extends RuntimeException{

    public AcessoInvalidoException() {
        super();
    }

    public AcessoInvalidoException(String message) {
        super(message);
    }
}
