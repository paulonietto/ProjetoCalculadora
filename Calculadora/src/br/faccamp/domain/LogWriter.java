package br.faccamp.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class LogWriter {
	public void WriteLog(String resultado)
	{
		FileWriter fw;
		try {
			fw = new FileWriter("log.csv", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(resultado);
			pw.flush();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}