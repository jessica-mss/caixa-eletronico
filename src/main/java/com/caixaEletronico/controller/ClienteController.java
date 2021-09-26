package com.caixaEletronico.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caixaEletronico.configuration.MD5;
import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.model.UserLogin;
import com.caixaEletronico.repository.ClienteRepository;
import com.caixaEletronico.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	private MD5 MD5;
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/cadastrar")
	Cliente novoCliente(@RequestBody Cliente novoCliente) {
	    return repository.save(novoCliente);
	  }

	@PostMapping("/logar")
	@ResponseStatus(value = HttpStatus.MULTIPLE_CHOICES)
	public HttpEntity<?> Autentication (@RequestBody UserLogin user) throws NoSuchAlgorithmException {
		if(service.logar(user)) {
			return ResponseEntity.ok(new MD5("logado").criarMD5());
			//TODO trocar resposta do m�todo por MD5 de login
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
