package com.caixaEletronico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.MULTIPLE_CHOICES)
public class ValorIndisponivelCaixaException extends RuntimeException{
    public ValorIndisponivelCaixaException() {
        super("VALOR INDISPONÍVEL, PROCURE OUTRO CAIXA");
    }

    public ValorIndisponivelCaixaException(String message) {
        super(message);
    }
}