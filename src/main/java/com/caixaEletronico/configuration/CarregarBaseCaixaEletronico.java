//package com.caixaEletronico.configuration;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import com.caixaEletronico.model.CaixaEletronico;
//import com.caixaEletronico.repository.CaixaEletronicoRepository;
//
//@Configuration
//public class CarregarBaseCaixaEletronico {
//	private static final Logger log = LoggerFactory.getLogger(CarregarBaseBancos.class);
//	
//	@Bean
//	CommandLineRunner initDatabase(CaixaEletronicoRepository repository) {
//		return args -> {
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//			log.info("Carregando" + repository.save(new CaixaEletronico(200, 200, 200, 200)));
//		};
//	}
//}
