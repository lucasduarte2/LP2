/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package excecoes;

public class GeneroInvalidoException extends Exception {

	public GeneroInvalidoException() {
		super("Genero da musica nao pode ser nulo ou vazio.");
	}

}
