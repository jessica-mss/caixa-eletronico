package com.caixaEletronico.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caixaEletronico.model.Banco;
import com.caixaEletronico.repository.BancoRepository;

@Configuration
public class CarregarBaseBancos {
private static final Logger log = LoggerFactory.getLogger(CarregarBaseBancos.class);
	
	@Bean
	CommandLineRunner initDatabaseBanco(BancoRepository repository) {
		
		return args -> {
			log.info("carregando" + repository.save(new Banco("003", "Banco da Amazônia")));
			log.info("carregando" + repository.save(new Banco("001", "Banco do Brasil")));
			log.info("carregando" + repository.save(new Banco("004", "Banco do Nordeste")));
			log.info("carregando" + repository.save(new Banco("077", "Banco Inter")));
			log.info("carregando" + repository.save(new Banco("079", "Banco Original")));
			log.info("carregando" + repository.save(new Banco("623", "Banco PAN")));
			log.info("carregando" + repository.save(new Banco("422", "Banco Safra")));
			log.info("carregando" + repository.save(new Banco("082", "Banco Topázio")));
			log.info("carregando" + repository.save(new Banco("021", "Banestes")));
			log.info("carregando" + repository.save(new Banco("318", "BMG")));
			log.info("carregando" + repository.save(new Banco("063", "Bradescard")));
			log.info("carregando" + repository.save(new Banco("036", "Bradesco")));
			log.info("carregando" + repository.save(new Banco("070", "Banco de Brasília")));
			log.info("carregando" + repository.save(new Banco("104", "Caixa Econômica Federal")));
			log.info("carregando" + repository.save(new Banco("739", "Cetelem")));
			log.info("carregando" + repository.save(new Banco("362", "Elo")));
			log.info("carregando" + repository.save(new Banco("184", "Itau")));
			log.info("carregando" + repository.save(new Banco("389", "Mercantil do Brasil")));
			log.info("carregando" + repository.save(new Banco("290", "PAG")));
			log.info("carregando" + repository.save(new Banco("074", "Safra")));
			log.info("carregando" + repository.save(new Banco("033", "Santander")));
			log.info("carregando" + repository.save(new Banco("756", "Sicoob")));
			log.info("carregando" + repository.save(new Banco("748", "Sicredi")));
		};
	}
}
