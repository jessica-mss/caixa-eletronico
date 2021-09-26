package com.caixaEletronico.configuration;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caixaEletronico.model.Banco;
import com.caixaEletronico.model.Cliente;
import com.caixaEletronico.repository.BancoRepository;
import com.caixaEletronico.repository.ClienteRepository;

@Configuration
public class CarregarBaseCliente {
	private static final Logger log = LoggerFactory.getLogger(CarregarBaseCliente.class);

	@Bean
	CommandLineRunner initDatabase2(ClienteRepository repository) {

		return args -> {
			log.info("carregando" + repository.save(new Cliente(1, "033", "santander", "00234", 1000, "xuxa meneghel",
					"login", "827ccb0eea8a706c4c34a16891f84e7b", "12345678", null, LocalDateTime.now())));

		};
	}
}
