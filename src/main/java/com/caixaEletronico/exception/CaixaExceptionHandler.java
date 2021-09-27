package com.caixaEletronico.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CaixaExceptionHandler
{
	@ExceptionHandler(AcessoInvalidoException.class)
	public ResponseEntity<Object> resourceNotFound(AcessoInvalidoException e, HttpServletRequest request)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
	}

	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<Object> saldoInsuficiente(SaldoInsuficienteException e, HttpServletRequest request)
	{
		return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES).body(new MensagemErro(e.getMessage()));
	}

	@ExceptionHandler(ValorIndisponivelCaixaException.class)
	public ResponseEntity<Object> valorIndisponivelCaixa(ValorIndisponivelCaixaException e, HttpServletRequest request)
	{
		return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES).body(new MensagemErro(e.getMessage()));
	}

	@ExceptionHandler({IllegalStateException.class, Exception.class})
	public ResponseEntity<MensagemErro> AplicationError(Exception e, HttpServletRequest request)
	{
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity.status(status).body(new MensagemErro("Erro na aplicação"));
	}
}