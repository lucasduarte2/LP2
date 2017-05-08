/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package excecoes;

public class DuracaoInvalidaException extends Exception {

	public DuracaoInvalidaException() {
		super("Duracao nao pode ser menor q zero");
	}
	public DuracaoInvalidaException(String msg) {
		super(msg);
	}
	

}
