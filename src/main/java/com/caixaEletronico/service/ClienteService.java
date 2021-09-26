package com.caixaEletronico.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.model.UserLogin;
import com.caixaEletronico.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository repository;

		public boolean logar(UserLogin user) {
		// TODO Auto-generated method stub
		List<Cliente> clienteEncontrado = new ArrayList<>();
		clienteEncontrado = repository.findByConta(user.getConta());
		if (clienteEncontrado.isEmpty()) {
			//deve devolver erro de usu�rio n�o encontrado
		}else {
			Cliente cliente = clienteEncontrado.get(0);
			
			if (user.getSenha().equals(cliente.getSenha())) {
				return true;
			}
		}
		return false;
	}

}
