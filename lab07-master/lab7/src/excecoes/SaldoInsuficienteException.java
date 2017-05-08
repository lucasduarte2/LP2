package excecoes;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {
		super("Saldo insuficiente para realizar a compra");
	}

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

}
