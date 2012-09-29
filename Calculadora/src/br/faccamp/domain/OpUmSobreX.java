package br.faccamp.domain;

public class OpUmSobreX {

	public String processaUmSobreX (String numeroS) {
		double numeroD = Double.parseDouble(numeroS);
		numeroS = String.valueOf(1/numeroD);
		return numeroS;
	}
}