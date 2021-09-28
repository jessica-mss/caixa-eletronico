package com.caixaEletronico.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caixaEletronico.exception.AcessoInvalidoException;
import com.caixaEletronico.model.AcessoRequest;
import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.model.ClienteRequest;
import com.caixaEletronico.model.ClienteResponse;
import com.caixaEletronico.model.Message;
import com.caixaEletronico.model.UserLogin;
import com.caixaEletronico.repository.ClienteRepository;
import com.caixaEletronico.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteService service;

	@GetMapping("/todos")
	public ResponseEntity<List<Cliente>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping(value = "/logar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.MULTIPLE_CHOICES)
	public HttpEntity<?> Autentication (@RequestBody UserLogin user) throws NoSuchAlgorithmException {
		String acesso = service.logar(user);
		
		if(!acesso.isEmpty()) {
			return ResponseEntity.ok(new Message(acesso));
		}

		return ResponseEntity.EMPTY;
	}

	@GetMapping
	public ResponseEntity<ClienteResponse> Get(@RequestBody AcessoRequest acessoRequest) {
		Cliente cliente = repository.findByAcesso(acessoRequest.getAcesso());
		if(cliente == null)
			throw new AcessoInvalidoException();
		return ResponseEntity.ok(new ClienteResponse(cliente.getCodigoBanco(), cliente.getNomeBanco(),cliente.getConta(),cliente.getNomeCliente(),cliente.getTelefoneCliente()));
	}

	
	@PutMapping("/")
	public HttpEntity<?> Put (@RequestBody ClienteRequest clienteRequest) {
		Cliente cliente = repository.findByAcesso(clienteRequest.getAcesso());
		if(cliente == null)
			throw new AcessoInvalidoException();
		cliente.setNomeCliente(clienteRequest.getNomeCliente());
		cliente.setTelefoneCliente(clienteRequest.getTelefoneCliente());
		repository.save(cliente);
		return ResponseEntity.EMPTY;
	}
	
	@PostMapping("/cadastrar")
	Cliente novoCliente(@RequestBody Cliente novoCliente) {
	    return repository.save(novoCliente);
	}	
}
