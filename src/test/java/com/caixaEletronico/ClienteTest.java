package com.caixaEletronico;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caixaEletronico.model.Cliente;

public class ClienteTest {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteTest.class);
	
	@Test
	public void testSetcodigoBanco() {
		Cliente p1 = new Cliente();
		p1.setCodigoBanco("123");
		assertEquals("123", p1.getCodigoBanco());
		
	}
	
	@Test
	public void testSetNomeBanco() {
		Cliente p1 = new Cliente();
		p1.setNomeBanco("Bradesco");
		assertEquals("Bradesco", p1.getNomeBanco());
	}
	@Test
	public void testSetconta() {
		Cliente p1 = new Cliente();
		p1.setConta("123456");
		assertEquals("123456", p1.getConta());
	}

	//@Test
	//public float testsetsaldoConta(float salcoConta) {
	//	Cliente p1 = new Cliente();
	//	p1.setsaldoConta("100,00");
	//	assertEquals("100,00", p1.getsaldoConta());
//}
	
	@Test
	public void testSetnomeCliente() {
		Cliente p1 = new Cliente();
		p1.setNomeCliente("Amanda");
		assertEquals("Amanda", p1.getNomeCliente());
	}
	
	@Test
	public void testSetlogin() {
		Cliente p1 = new Cliente();
		p1.setLogin("123456");
		assertEquals("123456", p1.getLogin());
}
	@Test
	public void testSetSenha() {
		Cliente p1 = new Cliente();
		p1.setSenha("***");
		assertEquals("***", p1.getSenha());
}
	@Test
	public void testSettelefoneCliente() {
		Cliente p1 = new Cliente();
		p1.setTelefoneCliente("11-99999-9999");
		assertEquals("11-99999-9999", p1.getTelefoneCliente());
}
	@Test
	public void testSetacesso() {
		Cliente p1 = new Cliente();
		p1.setAcesso("------");
		assertEquals("------", p1.getAcesso());
}
	//@Test
	//public void testSetdataAcesso(LocalDateTime dataAcesso) {
		//Cliente p1 = new Cliente();
		//p1.setDataAcesso("automatic");
		//assertEquals("Automatic", p1.getDataAcesso());
}
