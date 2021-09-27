package com.caixaEletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caixaEletronico.model.AcessoRequest;
import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.model.SaqueRequest;
import com.caixaEletronico.repository.CaixaEletronicoRepository;
import com.caixaEletronico.repository.ClienteRepository;

@Component
public class CaixaEletronicoServico {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CaixaEletronicoRepository caixaRepository;
	
	public float consultarSaldo (AcessoRequest acesso) {
		return repository.findByAcesso(acesso.getAcesso()).getSaldoConta();
	}

	public Object fazerSaque(SaqueRequest saqueRequest) {
		// TODO Auto-generated method stub
		Cliente cliente = repository.findByAcesso(saqueRequest.getAcesso());
		
		if (cliente.getSaldoConta() < saqueRequest.getValor()) {
			//retornar erro Response: Erro – 300 – saldo insuficiente:{"mensagem": "SALDO INSUFICIÊNTE"
		}
		float novoSaldo = cliente.getSaldoConta() - saqueRequest.getValor();
		cliente.setSaldoConta(novoSaldo);
		repository.save(cliente);
	}
}
