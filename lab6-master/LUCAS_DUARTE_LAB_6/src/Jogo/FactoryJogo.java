package Jogo;

import java.util.HashSet;

import excecoes.EstiloInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.PrecoInvalidoException;

public class FactoryJogo {

	/**
	 * Esse metodo cria um jogo de acordo com o especificado no parametro
	 * 
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @param estilo
	 * @return
	 * @throws NomeInvalidoException
	 * @throws PrecoInvalidoException
	 * @throws EstiloInvalidoException
	 */
	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades, String estilo)
			throws NomeInvalidoException, PrecoInvalidoException, EstiloInvalidoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new NomeInvalidoException("jogo");
		}
		if (preco < 0) {
			throw new PrecoInvalidoException();
		}
		if (estilo.equalsIgnoreCase("rpg")) {
			return new Rpg(nome, preco, jogabilidades);
		} else if (estilo.equalsIgnoreCase("plataforma")) {
			return new Plataforma(nome, preco, jogabilidades);
		} else if (estilo.equalsIgnoreCase("luta")) {
			return new Luta(nome, preco, jogabilidades);
		} else {
			throw new EstiloInvalidoException();
		}

	}

}
