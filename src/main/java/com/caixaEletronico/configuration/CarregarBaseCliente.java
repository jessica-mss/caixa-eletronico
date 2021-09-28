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
			log.info("carregando" + repository.save(new Cliente(1, "033", "Santander", "00234", 1000, "Xuxa meneghel",
					"login", "827ccb0eea8a706c4c34a16891f84e7b", "1234-5678", null, LocalDateTime.now())));
			log.info("carregando" + repository.save(new Cliente(2, "001", "Banco do Brasil", "00235", 50000, "Sasha meneghel",
					"login1", "078563f337ec6d6fedf131ddc857db19", "1111-1111", null, LocalDateTime.now())));
			log.info("carregando" + repository.save(new Cliente(3, "422", "Banco Safra", "00236", 3000, "Rihanna",
					"login2", "7692dcdc19e41e66c6ae2de54a696b25", "2222-2222", null, LocalDateTime.now())));
			log.info("carregando" + repository.save(new Cliente(4, "077", "Banco Inter", "00237", 4000, "Lady Gaga",
					"login3", "0f3e84acb19dff22f695f31dbe3e972a", "3333-3333", null, LocalDateTime.now())));
			log.info("carregando" + repository.save(new Cliente(5, "104", "Caixa Econômica Federal", "00238", 5000, "Madonna",
					"login4", "268e27056a3e52cf3755d193cbeb0594", "4444-4444", null, LocalDateTime.now())));
			log.info("carregando" + repository.save(new Cliente(6, "036", "Bradesco", "00239", 6000, "Shakira",
					"login5", "00c66aaf5f2c3f49946f15c1ad2ea0d3", "5555-5555", null, LocalDateTime.now())));
		};
	}
}
