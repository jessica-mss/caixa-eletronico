package com.caixaEletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caixaEletronico.exception.AcessoInvalidoException;
import com.caixaEletronico.exception.SaldoInsuficienteException;
import com.caixaEletronico.exception.ValorIndisponivelCaixaException;
import com.caixaEletronico.model.AcessoRequest;
import com.caixaEletronico.model.Banco;
import com.caixaEletronico.model.CaixaEletronico;
import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.model.SaldoResponse;
import com.caixaEletronico.model.SaqueRequest;
import com.caixaEletronico.model.SaqueResponse;
import com.caixaEletronico.repository.CaixaEletronicoRepository;
import com.caixaEletronico.repository.ClienteRepository;

@Component
public class CaixaEletronicoServico {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CaixaEletronicoRepository caixaRepository;
	
	public int cedulas50 = 0, cedulas10 = 0, cedulas5 = 0, cedulas2 = 0;
	
	public SaldoResponse consultarSaldo(AcessoRequest acesso){
		Cliente cliente;

		try{
			cliente = repository.findByAcesso(acesso.getAcesso());

			if(cliente == null){
				throw new AcessoInvalidoException();
			}
		}
		catch(Exception ex){
			throw ex;
		}

		return new SaldoResponse(cliente.getSaldoConta());
	}

	public SaqueResponse fazerSaque(SaqueRequest saqueRequest) {
		Cliente cliente;

		try{
			cliente = repository.findByAcesso(saqueRequest.getAcesso());

			if(cliente == null)
				throw new AcessoInvalidoException();
			
			if (cliente.getSaldoConta() < saqueRequest.getValor()) {
				throw new SaldoInsuficienteException();
			}

			CalculoQuantidadeCedulasSaque(saqueRequest.getValor());
			
			CaixaEletronico caixaEletronico = caixaRepository.findById(saqueRequest.getIdCaixa())
			.orElseThrow(()-> new IllegalArgumentException("Not found"));

			if(caixaEletronico.getQtdCedulas2() < cedulas2 
				|| caixaEletronico.getQtdCedulas5() < cedulas5
				|| caixaEletronico.getQtdCedulas10() < cedulas10
				|| caixaEletronico.getQtdCedulas50() < cedulas50)
			{
				throw new ValorIndisponivelCaixaException();
			}

			caixaEletronico.setQtdCedulas2(caixaEletronico.getQtdCedulas2() - cedulas2);
			caixaEletronico.setQtdCedulas5(caixaEletronico.getQtdCedulas5() - cedulas5);
			caixaEletronico.setQtdCedulas10(caixaEletronico.getQtdCedulas10() - cedulas10);
			caixaEletronico.setQtdCedulas50(caixaEletronico.getQtdCedulas50() - cedulas50);
			caixaRepository.save(caixaEletronico);

			float novoSaldo = cliente.getSaldoConta() - saqueRequest.getValor();
			cliente.setSaldoConta(novoSaldo);
			repository.save(cliente);
		}
		catch(Exception ex){
			throw ex;
		}

		return new SaqueResponse(new Banco(cliente.getCodigoBanco(), cliente.getNomeBanco()), cliente.getConta(), cedulas2, cedulas5, cedulas10, cedulas50);
	}

	private void CalculoQuantidadeCedulasSaque(float valorSaque) {
		Float resto = 0f;

		if(valorSaque >= 50){
			cedulas50 = (int)(valorSaque/50);
			resto = valorSaque % 50;
		}

		if(resto >= 10){
			cedulas10 = (int)(resto/10);
			resto = valorSaque % 10;
		}

		if(resto >= 5){
			cedulas5 = (int)(resto/5);
			resto = valorSaque % 5;
		}

		if(resto >= 2){
			cedulas2 = (int)(resto/2);
		}
	}
}