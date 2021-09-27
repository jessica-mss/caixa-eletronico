package com.caixaEletronico.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Banco {
	
	@Id
	@GeneratedValue
	private long idBanco;
	
	@NotNull
	private String codigoBanco;
	
	@NotNull
	private String nomeBanco;
	
	@OneToMany(mappedBy = "banco" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cliente> clientes = new ArrayList<>();
	
	Banco() {}
	
	
	public Banco(@NotNull String codigoBanco, @NotNull String nomeBanco) {
		super();
		this.codigoBanco = codigoBanco;
		this.nomeBanco = nomeBanco;
	}



	//Getters & Setters
	public long getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(long idBanco) {
		this.idBanco = idBanco;
	}

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

}
