package br.faccamp.domain;

public class OpLogaritmo {

	public String processaLogaritmo(String numeroS) {
		double numeroD = Double.parseDouble(numeroS);
		numeroS = String.valueOf(Math.log10(numeroD));
		return numeroS;
	}
}