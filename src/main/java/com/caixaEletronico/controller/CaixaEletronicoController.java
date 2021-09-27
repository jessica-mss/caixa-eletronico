package com.caixaEletronico.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.server.ResponseStatusException;
import com.caixaEletronico.exception.AcessoInvalidoException;
import com.caixaEletronico.model.AcessoRequest;
import com.caixaEletronico.model.CaixaEletronico;
import com.caixaEletronico.model.SaldoResponse;
import com.caixaEletronico.model.SaqueRequest;
import com.caixaEletronico.model.SaqueResponse;
import com.caixaEletronico.repository.CaixaEletronicoRepository;
import com.caixaEletronico.service.CaixaEletronicoServico;
import com.caixaEletronico.service.ClienteService;

@RestController
@RequestMapping("/caixa")
public class CaixaEletronicoController {
	
	@Autowired
	private CaixaEletronicoServico servico;

	@Autowired
	private CaixaEletronicoRepository repository;

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/todos")
	public ResponseEntity<List<CaixaEletronico>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/saldo")
	public  ResponseEntity<Object> consultarSaldo(@RequestBody AcessoRequest acessoRequest) {
		return ResponseEntity.ok(servico.consultarSaldo(acessoRequest));
	}
	
	@PostMapping("/saque")
	public ResponseEntity<SaqueResponse> fazerSaque(@RequestBody SaqueRequest saqueRequest) {
		return ResponseEntity.ok(servico.fazerSaque(saqueRequest));
	}
	
}
