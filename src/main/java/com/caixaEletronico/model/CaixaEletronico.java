package com.caixaEletronico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CaixaEletronico {
	
	@Id
	@GeneratedValue
	private Integer idCaixa;
	private int qtdCedulas2;
	private int qtdCedulas5;
	private int qtdCedulas10;
	private int qtdCedulas50;
	
	CaixaEletronico() {}
	
	public CaixaEletronico(int qtdCedulas2, int qtdCedulas5, int qtdCedulas10, int qtdCedulas50) {
		super();
		this.qtdCedulas2 = qtdCedulas2;
		this.qtdCedulas5 = qtdCedulas5;
		this.qtdCedulas10 = qtdCedulas10;
		this.qtdCedulas50 = qtdCedulas50;
	}
	
	//Getters & Setters
	public Integer getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(Integer idCaixa) {
		this.idCaixa = idCaixa;
	}

	public int getQtdCedulas2() {
		return qtdCedulas2;
	}

	public void setQtdCedulas2(int qtdCedulas2) {
		this.qtdCedulas2 = qtdCedulas2;
	}

	public int getQtdCedulas5() {
		return qtdCedulas5;
	}

	public void setQtdCedulas5(int qtdCedulas5) {
		this.qtdCedulas5 = qtdCedulas5;
	}

	public int getQtdCedulas10() {
		return qtdCedulas10;
	}

	public void setQtdCedulas10(int qtdCedulas10) {
		this.qtdCedulas10 = qtdCedulas10;
	}

	public int getQtdCedulas50() {
		return qtdCedulas50;
	}

	public void setQtdCedulas50(int qtdCedulas50) {
		this.qtdCedulas50 = qtdCedulas50;
	}
	
		
//	@Id
//	@GeneratedValue
//	private Integer idCaixa;
//	public int dois;
//	public int cinco;
//	public int dez;
//	public int cinquenta;
//	
//	public final int CINQUENTA = 50;
//	public final int DEZ = 10;
//	public final int CINCO = 5;
//	public final int DOIS = 2;
//	
//	/**
//	 * @param dois
//	 * @param cinco
//	 * @param dez
//	 * @param cinquenta
//	 */
//	public CaixaEletronico() {
//		this.dois = 200;
//		this.cinco = 200;
//		this.dez = 200;
//		this.cinquenta = 200;
//	}
//	
//	public void carregarCedulas() {
//		this.dois += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 2,00."));
//
//		this.cinco += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 5,00."));
//
//
//		this.dez += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 10,00."));
//
//
//		this.cinquenta += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 50,00."));
//	}
//	
//	public String sacar (int valor) {
//		int dois = 0, cinco = 0, dez = 0, cinquenta = 0, aux = 0;
//		
//		String retorno = "";
//		
//		cinquenta = extrairCedulas(valor, 50, this.CINQUENTA);
//		valor = valor -(cinquenta * 50);
//		
//		dez = extrairCedulas(valor, 10, this.DEZ);
//		valor = valor - (dez * 10);
//		
//		cinco = extrairCedulas(valor, 5, this.CINCO);
//		valor = valor - (cinco * 5);
//		
//		dois = extrairCedulas(valor, 2, this.DOIS);
//		valor = valor - (dois * 2);
//		
//		if (valor == 0) {
//			retorno = cinquenta + " de R$ 50,00/n"
//				+ dez + " de R$ 10,00/n"
//				+ cinco + " de R$ 5,00/n"
//				+ dois + " de R$ 2,00/n";
//			return retorno;
//		} else {
//			return "informar ao usuario que não foi possivel entregar a quantia desejada";
//		}
//}
//
//	public int extrairCedulas(int valor, int nota, int cedula) {
//		int aux = 0, qtd = 0, est = 0;
//		
//		est = getEstoque(cedula);
//		
//		if (valor >= nota) {
//			aux = valor % nota;
//			qtd = (valor - aux) / nota;
//			valor = aux;
//			if (est > 0) {
//				if (est < qtd) {
//					valor += (qtd - est) * nota;
//					qtd = est;
//				}
//			}
//		}
//		return qtd;
//	}
//
//	public int getEstoque(int cedula) {
//		int est = 0;
//		switch (cedula) {
//		case CINQUENTA:
//			est = this.cinquenta;
//			break;
//		case DEZ:
//			est = this.dez;
//			break;
//		case CINCO:
//			est = this.cinco;
//			break;
//		case DOIS:
//			est = this.dois;
//			break;
//		}
//		return est;
//	}
//		
//		
//	private String ler(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
	


