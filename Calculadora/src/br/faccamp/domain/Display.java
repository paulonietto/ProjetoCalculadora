package br.faccamp.domain;

import br.faccamp.view.CalculadoraGUI;

public class Display {

	private CalculadoraGUI gui;

	public Display(CalculadoraGUI gui) {
		this.gui = gui;
	}

	public double converterDisplay() {
		return Double.parseDouble(getDisplay());
	}

	public void mostrarMemoria(double memoria) {
		setDisplay(String.valueOf(memoria));
	}

	public String getDisplay() {
		return gui.getDisplay().getText();
	}

	public void setDisplay(String texto) {
		this.gui.getDisplay().setText(texto);

	}

	public void limpar() {
		setDisplay("");

	}
	public void atualizaVirgula(String string){
		if(getDisplay().equalsIgnoreCase("")){
			setDisplay("0.");
		}
		if(getDisplay().indexOf(".") == -1){
			atualiza(".");
			}
		}
	public void atualiza(String texto) {
		if (getDisplay().equalsIgnoreCase("") || getDisplay() == null) {
			setDisplay(texto);
		} else {
			setDisplay(getDisplay() + texto);
		}
	}
}
