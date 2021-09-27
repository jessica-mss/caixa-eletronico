package com.caixaEletronico.configuration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class MD5 {
	//public static String 
	
	private String message;
	
	private MessageDigest codificador;
	
	public MD5 (String message) throws NoSuchAlgorithmException {
		this.message = message;
		this.codificador = MessageDigest.getInstance("MD5");
	}
public String criarMD5 () {
	codificador.update(this.message.getBytes());
	return DatatypeConverter.printHexBinary(codificador.digest());
	
}
}
