package usuario;

import Jogo.Jogo;
import excecoes.JogoInvalidoException;
import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.SaldoInsuficienteException;

public class Noob extends Usuario {

	private final double DESCONTO = 0.90;

	/**
	 * O construtor do objeto Noob, que eh um tipo de usuario, foi herdado do
	 * objeto Usuario.
	 * 
	 * @param nome
	 * @param login
	 * @throws NomeInvalidoException
	 * @throws LoginInvalidoException
	 */
	public Noob(String nome, String login) throws NomeInvalidoException, LoginInvalidoException {
		super(nome, login);
		super.x2p = 0;
	}

	/**
	 * Esse metodo sobrescreve o desconto da super classe.
	 */
	@Override
	protected double desconto(Jogo jogo) {
		return jogo.getPreco() * DESCONTO;
	}

	/**
	 * Esse metodo sobrescreve o x2pPorCompra da super classe.
	 */
	@Override
	protected int x2pPorCompra(Jogo jogo) {
		int x2p = (int) (jogo.getPreco());
		return x2p * 10;
	}

	/**
	 * Esse metodo sobrescreve o compraJogo da super classe.
	 */
	@Override
	public void compraJogo(Jogo jogo) throws JogoInvalidoException, SaldoInsuficienteException {
		if (jogo == null) {
			throw new JogoInvalidoException();
		}
		if (getSaldo() <= desconto(jogo)) {
			throw new SaldoInsuficienteException();
		}
		setX2p(getX2p() + x2pPorCompra(jogo));
		setSaldo(getSaldo() - desconto(jogo));
		addJogo(jogo);

	}

	@Override
	public String toString() {
		String string = this.getLogin() + FIM_DE_LINHA;
		string += this.getNome() + " - Jogador Noob" + FIM_DE_LINHA;
		string += "Lista de Jogos:" + FIM_DE_LINHA;
		string += FIM_DE_LINHA;
		string += "Total de preco dos jogos: " + this.totalGastoNaStreem() + FIM_DE_LINHA;
		return string;
	}

}
