package excecoes;

public class NomeInvalidoException extends Exception {
	public NomeInvalidoException(String msg) {
		super("Nome do " + msg + " invalido");
	}

}
