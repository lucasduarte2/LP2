/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package excecoes;

public class AnoInvalidoException extends Exception {
	private static final long serialVersionUID = 1642433346982704457L;

	public AnoInvalidoException() {
		super("Ano de lancamento do album nao pode ser inferior a 1900.");
	}

}
