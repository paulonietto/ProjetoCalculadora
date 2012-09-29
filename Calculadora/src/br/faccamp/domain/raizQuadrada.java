package br.faccamp.domain;

public class raizQuadrada {

	public String processaRaiz(String numeroS) {
		double numeroD = Double.parseDouble(numeroS);
		numeroS = String.valueOf(Math.sqrt(numeroD));
		return numeroS;
	}
}
