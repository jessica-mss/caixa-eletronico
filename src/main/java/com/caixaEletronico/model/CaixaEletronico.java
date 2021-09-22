package com.caixaEletronico.model;

public class CaixaEletronico {
	public int dois;
	public int cinco;
	public int dez;
	public int cinquenta;
	
	public final int CINQUENTA = 50;
	public final int DEZ = 10;
	public final int CINCO = 5;
	public final int DOIS = 2;
	
	/**
	 * @param dois
	 * @param cinco
	 * @param dez
	 * @param cinquenta
	 */
	public CaixaEletronico() {
		this.dois = 200;
		this.cinco = 200;
		this.dez = 200;
		this.cinquenta = 200;
	}
	
	public void carregarCedulas() {
		this.dois += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 2,00."));

		this.cinco += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 5,00."));


		this.dez += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 10,00."));


		this.cinquenta += Integer.parseInt(ler("Informe a quantidade de cédulas de" + "R$ 50,00."));
	}
	
	public String sacar (int valor) {
		int dois = 0, cinco = 0, dez = 0, cinquenta = 0, aux = 0;
		
		String retorno = "";
		
		cinquenta = extrairCedulas(valor, 50, this.CINQUENTA);
		valor = valor -(cinquenta * 50);
		
		dez = extrairCedulas(valor, 10, this.DEZ);
		valor = valor - (dez * 10);
		
		cinco = extrairCedulas(valor, 5, this.CINCO);
		valor = valor - (cinco * 5);
		
		dois = extrairCedulas(valor, 2, this.DOIS);
		valor = valor - (dois * 2);
		
		if (valor == 0) {
			retorno = cinquenta + " de R$ 50,00/n"
				+ dez + " de R$ 10,00/n"
				+ cinco + " de R$ 5,00/n"
				+ dois + " de R$ 2,00/n";
			return retorno;
		} else {
			return "informar ao usuario que não foi possivel entregar a quantia desejada";
		}
}

	public int extrairCedulas(int valor, int nota, int cedula) {
		int aux = 0, qtd = 0, est = 0;
		
		est = getEstoque(cedula);
		
		if (valor >= nota) {
			aux = valor % nota;
			qtd = (valor - aux) / nota;
			valor = aux;
			if (est > 0) {
				if (est < qtd) {
					valor += (qtd - est) * nota;
					qtd = est;
				}
			}
		}
		return qtd;
	}

	public int getEstoque(int cedula) {
		int est = 0;
		switch (cedula) {
		case CINQUENTA:
			est = this.cinquenta;
			break;
		case DEZ:
			est = this.dez;
			break;
		case CINCO:
			est = this.cinco;
			break;
		case DOIS:
			est = this.dois;
			break;
		}
		return est;
	}
		
		
	private String ler(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
	


