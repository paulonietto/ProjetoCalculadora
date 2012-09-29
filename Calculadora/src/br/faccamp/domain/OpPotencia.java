package br.faccamp.domain;

public class OpPotencia extends Operacoes {

	public OpPotencia(String primeiroOperador) {
		super(primeiroOperador);
	}

	@Override
	public double calcula(String segundoOperador) {
		double primeiro = new Double(getPrimeiroOperador());
		double segundo = new Integer(segundoOperador);
		return (Math.pow(primeiro, segundo));
	}
}
