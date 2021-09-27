package com.caixaEletronico.service;

import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caixaEletronico.configuration.MD5;
import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.model.UserLogin;
import com.caixaEletronico.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository repository;

	public String logar(UserLogin user) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		List<Cliente> clienteEncontrado = new ArrayList<>();
		clienteEncontrado = repository.findByConta(user.getConta());
		if (clienteEncontrado.isEmpty()) {
			// deve devolver erro de usu�rio n�o encontrado
		} else {
			Cliente cliente = clienteEncontrado.get(0);

			MD5 md5 = new MD5(user.getSenha());
			if (md5.criarMD5().equalsIgnoreCase(cliente.getSenha())) {
				cliente.setAcesso(new MD5(cliente.getNomeCliente() + cliente.getConta()+ LocalDateTime.now().toString()).criarMD5());
				cliente.setDataAcesso(LocalDateTime.now());
				repository.save(cliente);
				return cliente.getAcesso();
			}
		}
		return "";
	}

	public boolean SessaoEstaExpirada(String acesso) {
		Cliente clienteEncontrado = repository.findByAcesso(acesso);

		long tempoLogado = Duration.between(clienteEncontrado.getDataAcesso(), LocalDateTime.now()).toMinutes();

		return tempoLogado > 15;
	}
}
