package br.faccamp.domain;

public abstract class Operacoes {
	protected LogWriter log;
	private String primeiroOperador;

	public abstract double calcula(String conteudo) ;

	public Operacoes(String primeiroOperador) {
		this.primeiroOperador = primeiroOperador;
	}

	public String getPrimeiroOperador() {
		return primeiroOperador;
	}

	public void setPrimeiroOperador(String primeiroOperador) {
		this.primeiroOperador = primeiroOperador;
	}
	
	
}