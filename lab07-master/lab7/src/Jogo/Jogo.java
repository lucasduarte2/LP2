package Jogo;

import java.util.HashSet;
import java.util.Set;

import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.PontuacaoInvalidaException;
import excecoes.PrecoInvalidoException;

public abstract class Jogo {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	private String nome;
	private double preco;
	private int maiorScore;
	protected int quantidadeJogada;
	private int vezesZeradas;
	private HashSet<Jogabilidade> jogabilidade;

	/**
	 * Construtor da classe Jogo. com 2 parametros
	 * 
	 * @param nome
	 * @param preco
	 * @throws NomeInvalidoException
	 * @throws PrecoInvalidoException
	 */
	public Jogo(String nome, double preco) throws NomeInvalidoException, PrecoInvalidoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new NomeInvalidoException("jogo");
		}
		if (preco < 0) {
			throw new PrecoInvalidoException();
		}
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.quantidadeJogada = 0;
		this.vezesZeradas = 0;
		this.jogabilidade = new HashSet<Jogabilidade>();
	}

	/**
	 * Construtor da classe Jogo. com 3 parametros
	 * 
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @throws NomeInvalidoException
	 * @throws PrecoInvalidoException
	 */
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades)
			throws NomeInvalidoException, PrecoInvalidoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new NomeInvalidoException("jogo");
		}
		if (preco < 0) {
			throw new PrecoInvalidoException();
		}
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.quantidadeJogada = 0;
		this.vezesZeradas = 0;
		this.jogabilidade = jogabilidades;
	}

	/**
	 * Metodo abstract que registra jogada
	 * 
	 * @param score
	 * @param zerou
	 * @return
	 * @throws Exception
	 */
	public abstract int registraJogada(int score, boolean zerou) throws Exception;

	@Override
	public String toString() {
		String resultado = "==> Jogou " + getQuantidadeJogada() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Zerou " + getVezesZeradas() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Maior Score: " + getMaiorScore() + FIM_DE_LINHA;
		return resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogabilidade == null) ? 0 : jogabilidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Jogo))
			return false;
		Jogo other = (Jogo) obj;
		if (jogabilidade == null) {
			if (other.jogabilidade != null)
				return false;
		} else if (!jogabilidade.equals(other.jogabilidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new NomeInvalidoException("Jogo");
		}
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) throws PrecoInvalidoException {
		if (preco < 0) {
			throw new PrecoInvalidoException();
		}
		this.preco = preco;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(int maiorScore) throws PontuacaoInvalidaException {
		if (maiorScore < 0) {
			throw new PontuacaoInvalidaException();
		}
		this.maiorScore = maiorScore;
	}

	public int getQuantidadeJogada() {
		return quantidadeJogada;
	}

	public void setQuantidadeJogada(int quantidadeJogada) throws Exception {
		if (quantidadeJogada < 0) {
			throw new Exception("quantidadeJogada invalida");
		}
		this.quantidadeJogada = quantidadeJogada;
	}

	public int getVezesZeradas() {
		return vezesZeradas;
	}

	public void setVezesZeradas(int vezesZeradas) throws Exception {
		if (vezesZeradas < 0) {
			throw new Exception("vezesZeradas invalida");
		}
		this.vezesZeradas = vezesZeradas;
	}

	public HashSet<Jogabilidade> getJogabilidade() {
		return jogabilidade;
	}

	public void setJogabilidade(HashSet<Jogabilidade> jogabilidade) {
		this.jogabilidade = jogabilidade;
	}

}
