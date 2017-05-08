package Jogo;

import java.util.HashSet;

import excecoes.NomeInvalidoException;
import excecoes.PontuacaoInvalidaException;
import excecoes.PrecoInvalidoException;

public class Rpg extends Jogo {

	/**
	 * O construtor do objeto Rpg, que eh um estilo de jogo, foi herdado do
	 * objeto Jogo.
	 * 
	 * @param nome
	 * @param preco
	 * @throws NomeInvalidoException
	 * @throws PrecoInvalidoException
	 */
	public Rpg(String nome, double preco) throws NomeInvalidoException, PrecoInvalidoException {
		super(nome, preco);

	}

	/**
	 * O construtor do objeto Rpg, que eh um estilo de jogo, foi herdado do
	 * objeto Jogo.
	 * 
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @throws NomeInvalidoException
	 * @throws PrecoInvalidoException
	 */
	public Rpg(String nome, double preco, HashSet<Jogabilidade> jogabilidades)
			throws NomeInvalidoException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
	}

	/**
	 * Esse metodo sobrescreve o registraJogada da super classe.
	 * 
	 * @throws Exception
	 */
	@Override
	public int registraJogada(int score, boolean zerou) throws Exception {
		this.setQuantidadeJogada(getQuantidadeJogada() + 1);
		if (score < 0) {
			throw new PontuacaoInvalidaException();
		}
		if (zerou == true) {
			this.setVezesZeradas(getVezesZeradas() + 1);
		}
		if (score > getMaiorScore()) {
			setMaiorScore(score);
		}
		return 10;
	}

	public String toString() {
		String resultado = getNome() + " - Rpg:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}

}
