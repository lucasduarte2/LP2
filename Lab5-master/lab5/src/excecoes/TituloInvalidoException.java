/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package excecoes;

public class TituloInvalidoException extends Exception {
	public TituloInvalidoException(String msg) {
		super(msg + " nao pode ser nulo ou vazio.");
	}

}
