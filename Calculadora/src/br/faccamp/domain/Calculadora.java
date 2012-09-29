package br.faccamp.domain;

import java.util.ArrayList;

import br.faccamp.view.CalculadoraGUI;

public class Calculadora {

	private CalculadoraGUI gui;
	private Display display;
	private double memoria;
	private Operacoes operacoes;
	private LogWriter log;
	private ArrayList<String> lista;// = new ArrayList<String>();
	private int indice;

	// List<String> opAtual = new List<String>()

	public Calculadora() {
		gui = new CalculadoraGUI(this);
		display = new Display(gui);
		this.log = new LogWriter();
		indice = -1;
		this.lista = new ArrayList<String>();
	}

	public void processaMC() {
		memoria = 0;

	}

	public void processaMR() {
		display.mostrarMemoria(memoria);

	}

	public void processaMS() {
		memoria = display.converterDisplay();

	}

	public void processaMMais() {
		memoria += display.converterDisplay();

	}

	public void processaMMenos() {
		memoria -= display.converterDisplay();

	}

	public void processaCE() {
		display.limpar();
	}

	public void processaC() {
		display.limpar();
		operacoes.setPrimeiroOperador("");

	}

	public void processaRaiz() {
		log.WriteLog("Raiz de " + display.getDisplay());
		raizQuadrada raiz = new raizQuadrada();
		display.setDisplay(raiz.processaRaiz(display.getDisplay()));
		log.WriteLog(" = " + display.getDisplay() + " , ");

	}

	public void processaMaisOuMenos() {
		display.setDisplay(String.valueOf(maisOuMenos()));

	}

	public void processaFatorial() {
		log.WriteLog("Fatorial de " + display.getDisplay());
		String numeroEmTexto = display.getDisplay();
		double numero = Double.parseDouble(numeroEmTexto);
		display.setDisplay(String.valueOf(fatorial(numero)));
		log.WriteLog(" = " + display.getDisplay() + " , ");
		AddLista();
	}

	public void processaSete() {
		display.atualiza("7");
	}

	public void processaOito() {
		display.atualiza("8");

	}

	public void processaNove() {
		display.atualiza("9");

	}

	public void processaDivisao() {
		operacoes = new OpDivisao(display.getDisplay());
		log.WriteLog("Divisão "+ display.getDisplay() + " / ");
		display.limpar();

	}

	public void processaPorcentual() {
		if (operacoes.getPrimeiroOperador() != "") {
			double primeiro = new Double(operacoes.getPrimeiroOperador());
			double segundo = new Double(display.getDisplay());
			segundo = (primeiro * segundo) / 100;
			display.setDisplay(String.valueOf(segundo));
		}

	}

	public void processaQuatro() {
		display.atualiza("4");

	}

	public void processaCinco() {
		display.atualiza("5");
	}

	public void processaSeis() {
		display.atualiza("6");
	}

	public void processaVezes() {
		operacoes = new OpVezes(display.getDisplay());
		log.WriteLog("Multiplicação "+ display.getDisplay() + " x ");
		display.limpar();

	}

	public void processaUmSobreX() {
		log.WriteLog("1/" + display.getDisplay());
		OpUmSobreX umsobrex = new OpUmSobreX();
		display.setDisplay(umsobrex.processaUmSobreX(display.getDisplay()));
		log.WriteLog(" = " + display.getDisplay() + " , ");
		AddLista();
	}

	public void processaUm() {
		display.atualiza("1");
	}

	public void processaDois() {
		display.atualiza("2");

	}

	public void processaTres() {
		display.atualiza("3");

	}

	public void processaMenos() {
		operacoes = new OpSubtracao(display.getDisplay());
		log.WriteLog("Subtração "+ display.getDisplay() + " - ");
		display.limpar();

	}

	public void processaXElevadoY() {
		operacoes = new OpPotencia(display.getDisplay());
		log.WriteLog("Potência "+ display.getDisplay() + " ^ ");
		display.limpar();

	}

	public void processaZero() {
		display.atualiza("0");
	}

	public void processaVirgula() {
		display.atualizaVirgula(".");
	}

	public void processaIgual() {
		String conteudo = display.getDisplay();
		log.WriteLog(display.getDisplay());
		display.limpar();
		try {
			display.atualiza(String.valueOf(operacoes.calcula(conteudo)));
			AddLista();
			log.WriteLog(" = "+ display.getDisplay() + " , ");
			
		} catch (ArithmeticException e) {
			display.atualiza("Math Error");
		}
	}

	public void processaLog() {
		log.WriteLog("Log de " + display.getDisplay());
		OpLogaritmo logaritmo = new OpLogaritmo();
		display.setDisplay(logaritmo.processaLogaritmo(display.getDisplay()));
		log.WriteLog(" = " + display.getDisplay() + " , ");
		AddLista();
	}

	public void processaMais() {
		operacoes = new OpSoma(display.getDisplay());
		log.WriteLog("Soma "+ display.getDisplay() + " + ");
		display.limpar();
	}

	public void processaDo(int i) {
		try {
			indice += i;

			display.setDisplay((lista.get(indice)));

		} catch (Exception e) {
			display.setDisplay("Syntax Error");
		}

	}

	// ~~~ Classes de auxílio ~~~//
	private void AddLista() {
		lista.add(display.getDisplay());
		indice += 1;
		System.out.println(lista);

	}

	private double fatorial(double numero) {
		if (numero == 1) {
			return 1;
		} else {
			return numero * fatorial(numero - 1);
		}
	}

	private double maisOuMenos() {
		double p = display.converterDisplay();
		return (p * -1);

	}
}
