/* 115210384 - LUCAS VENANCIO DUARTE: LAB 3 - Turma 3 */
package Lab03;

import java.util.Scanner;

public class Leitura {

	int leituraInteiro() {
		Scanner teclado = new Scanner(System.in);
		int entrada = teclado.nextInt();
		return entrada;
	}

	double leituraDouble() {
		Scanner teclado = new Scanner(System.in);
		double entrada = teclado.nextDouble();
		return entrada;
	}

	String leituraFrase() {
		Scanner teclado = new Scanner(System.in);
		String entrada = teclado.nextLine();
		return entrada;
	}

	String leituraPalavra() {
		Scanner teclado = new Scanner(System.in);
		String entrada = teclado.next();
		return entrada;
	}
	
}