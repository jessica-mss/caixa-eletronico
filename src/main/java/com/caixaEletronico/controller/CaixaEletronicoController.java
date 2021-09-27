package com.caixaEletronico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caixaEletronico.model.AcessoRequest;
import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.model.SaqueRequest;
import com.caixaEletronico.model.SaqueResponse;
import com.caixaEletronico.repository.ClienteRepository;
import com.caixaEletronico.service.CaixaEletronicoServico;

@RestController
@RequestMapping("/caixa")
public class CaixaEletronicoController {
	
	@Autowired
	private CaixaEletronicoServico servico;
	
	@GetMapping("/consultarSaldo")
	public ResponseEntity<Float>  ConsultarSaldo(@RequestBody AcessoRequest acessoRequest) {
		return ResponseEntity.ok(servico.consultarSaldo(acessoRequest));
	}
	
	@PostMapping("/fazerSaque")
	public ResponseEntity<SaqueResponse> fazerSaque(@RequestBody SaqueRequest saqueRequest) {
		return ResponseEntity.ok(servico.fazerSaque(saqueRequest));
	}
	
}
