package br.faccamp.domain;

public class OpSubtracao extends Operacoes {

	public OpSubtracao(String primeiroOperador) {
		super(primeiroOperador);
	}

	@Override
	public double calcula(String segundoOperador) {
		double primeiro = new Double(getPrimeiroOperador());
		double segundo = new Double(segundoOperador);
		return (primeiro - segundo);
	}
}