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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caixaEletronico.model.AcessoRequest;
import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.model.ClienteRequest;
import com.caixaEletronico.model.ClienteResponse;
import com.caixaEletronico.repository.ClienteRepository;
import com.caixaEletronico.configuration.MD5;
import com.caixaEletronico.model.Cliente;
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
	
	private MD5 MD5;
	
	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<ClienteResponse> Get(@RequestBody AcessoRequest acessoRequest) {
		Cliente cliente = repository.findByAcesso(acessoRequest.getAcesso());
		
		return ResponseEntity.ok(new ClienteResponse(cliente.getBanco(),cliente.getConta(),cliente.getNomeCliente(),cliente.getTelefoneCliente()));
	}
	
//	@PostMapping("/cadastrar")
//	Cliente novoCliente(@RequestBody Cliente novoCliente) {
//	    return repository.save(novoCliente);
//	  }
	
	@PutMapping("/")
	public Cliente Put (@RequestBody ClienteRequest clienteRequest) {
		Cliente cliente = repository.findByAcesso(clienteRequest.getAcesso());
		cliente.setNomeCliente(clienteRequest.getNomeCliente());
		cliente.setTelefoneCliente(clienteRequest.getTelefoneCliente());
		return repository.save(cliente);
	} 


	
	@GetMapping
	public ResponseEntity<List<Cliente>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/cadastrar")
	Cliente novoCliente(@RequestBody Cliente novoCliente) {
	    return repository.save(novoCliente);
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

//	@GetMapping("/{id}")
//	public ResponseEntity<Usuario> GetById(@PathVariable long id) {
//		return repository.findById(id)
//				.map(resp -> ResponseEntity.ok(resp))
//				.orElse(ResponseEntity.notFound().build());
//	}
//	
//	@GetMapping("/nome/{nome}")
//	public ResponseEntity<List<Usuario>> GetByName(@PathVariable String nome){
//		return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
//	}
//	
//	@PutMapping("/alterar")
//	public ResponseEntity<Usuario> Put (@RequestBody Usuario usuario) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
//	}
//	
//	@DeleteMapping("/deletar/{id}")
//	public void delete (@PathVariable long id) {
//		repository.deleteById(id);
//		//COLOCAR MENSAGEM DE "DELETADO COM SUCESSO"
//	}
	
}
