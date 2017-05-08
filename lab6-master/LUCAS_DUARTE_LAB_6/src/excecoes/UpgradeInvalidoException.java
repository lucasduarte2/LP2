package excecoes;

public class UpgradeInvalidoException extends Exception {

	public UpgradeInvalidoException() {
		super("Impossivel realizar upgrade, quantidade de x2p insuficiente!");
	}

}
