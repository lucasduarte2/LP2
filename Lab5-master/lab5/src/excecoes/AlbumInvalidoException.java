/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package excecoes;

public class AlbumInvalidoException extends Exception {

	public AlbumInvalidoException() {
		super("Album nao pode ser vazio ou nulo");
	}
	
	
	public AlbumInvalidoException(String msg) {
		super (msg);
	}

}
