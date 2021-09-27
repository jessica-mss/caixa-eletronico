package com.caixaEletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javassist.NotFoundException;

import com.caixaEletronico.model.AcessoRequest;
import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.model.SaldoResponse;
import com.caixaEletronico.model.SaqueRequest;
import com.caixaEletronico.repository.CaixaEletronicoRepository;
import com.caixaEletronico.model.SaqueResponse;
import com.caixaEletronico.model.Banco;
import com.caixaEletronico.model.CaixaEletronico;
import com.caixaEletronico.repository.ClienteRepository;

@Component
public class CaixaEletronicoServico {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CaixaEletronicoRepository caixaRepository;
	
	public SaldoResponse consultarSaldo (AcessoRequest acesso) {
		return new SaldoResponse(repository.findByAcesso(acesso.getAcesso()).getSaldoConta());
	}

	public SaqueResponse fazerSaque(SaqueRequest saqueRequest) {
		Cliente cliente = repository.findByAcesso(saqueRequest.getAcesso());
		
		if (cliente.getSaldoConta() < saqueRequest.getValor()) {
			//retornar erro Response: Erro – 300 – saldo insuficiente:{"mensagem": "SALDO INSUFICIÊNTE"
		}

		float novoSaldo = cliente.getSaldoConta() - saqueRequest.getValor();
		cliente.setSaldoConta(novoSaldo);
		repository.save(cliente);

		int cedulas50 = 0, cedulas10 = 0, cedulas5 = 0, cedulas2 = 0;
		Float resto = 0f;

		if(saqueRequest.getValor() >= 50){
			cedulas50 = (int)(saqueRequest.getValor()/50);
			resto = saqueRequest.getValor() % 50;
		}

		if(resto >= 10){
			cedulas10 = (int)(resto/10);
			resto = saqueRequest.getValor() % 10;
		}

		if(resto >= 5){
			cedulas5 = (int)(resto/5);
			resto = saqueRequest.getValor() % 5;
		}

		if(resto >= 2){
			cedulas2 = (int)(resto/2);
		}
		
		CaixaEletronico caixaEletronico = caixaRepository.findById(saqueRequest.getIdCaixa()).orElseThrow(()-> new IllegalArgumentException("Not found"));

		if(caixaEletronico.getQtdCedulas2() < cedulas2 
			|| caixaEletronico.getQtdCedulas5() < cedulas5
			|| caixaEletronico.getQtdCedulas10() < cedulas10
			|| caixaEletronico.getQtdCedulas50() < cedulas50)
		{
			//disparar exception de saldo indisponivel
		}

		caixaEletronico.setQtdCedulas2(caixaEletronico.getQtdCedulas2() - cedulas2);
		caixaEletronico.setQtdCedulas5(caixaEletronico.getQtdCedulas5() - cedulas5);
		caixaEletronico.setQtdCedulas10(caixaEletronico.getQtdCedulas10() - cedulas10);
		caixaEletronico.setQtdCedulas50(caixaEletronico.getQtdCedulas50() - cedulas50);
		caixaRepository.save(caixaEletronico);

		return new SaqueResponse(new Banco(cliente.getCodigoBanco(), cliente.getNomeBanco()), cliente.getConta(), cedulas2, cedulas5, cedulas10, cedulas50);
	}
}
