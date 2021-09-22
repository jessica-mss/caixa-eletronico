package com.caixaEletronico.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.caixaEletronico.model.UserLogin;
import com.caixaEletronico.model.Usuario;
import com.caixaEletronico.repository.UsuarioRepository;
import com.caixaEletronico.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication (@RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
//	
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
