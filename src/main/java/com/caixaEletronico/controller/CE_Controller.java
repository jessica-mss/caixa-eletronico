package com.caixaEletronico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class CE_Controller {
	
	@GetMapping
	public String home() {
		return "Sejam bem vindos";
	}
}
