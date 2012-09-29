package br.faccamp.domain;

public class OpDivisao extends Operacoes {

	public OpDivisao(String primeiroOperador) {
		super(primeiroOperador);
	}

	@Override
	public double calcula(String segundoOperador) {

		double primeiro = new Double(getPrimeiroOperador());
		double segundo = new Double(segundoOperador);
		if (segundo == 0) {
			throw new ArithmeticException();
		} else {
			return (primeiro / segundo);
		}

	}
}
