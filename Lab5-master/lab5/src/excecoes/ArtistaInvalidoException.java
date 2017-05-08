/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package excecoes;

public class ArtistaInvalidoException extends Exception {

	public ArtistaInvalidoException() {
		super("Artista do album nao pode ser nulo ou vazio.");
	}

}
