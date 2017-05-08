package excecoes;

public class UpgradeInvalidoException extends Exception {

	public UpgradeInvalidoException() {
		super("Upgrade impossivel de ser realizado, usuario ja eh veterano");
	}
	public UpgradeInvalidoException(String msg) {
		super(msg);
	}

}
