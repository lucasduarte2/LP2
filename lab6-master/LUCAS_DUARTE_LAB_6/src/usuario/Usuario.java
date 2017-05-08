package usuario;

import java.util.ArrayList;

import Jogo.Jogo;
import excecoes.JogoInvalidoException;
import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.SaldoInsuficienteException;

public abstract class Usuario {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	private String nome;
	private String login;
	private double saldo;
	protected int x2p;
	private ArrayList<Jogo> listaDeJogos;

	/**
	 * O construtor Usuario inicializa duas variaveis de instancia como duas
	 * Strings duas variavens como zero, uma como sendo uma colecao, e um tipo
	 * de usuario totalizando seis variaveis. Isso assegura que objetos Usuario
	 * iniciem em um estado consistente.
	 * 
	 * @param nome
	 * @param login
	 * @throws NomeInvalidoException
	 * @throws LoginInvalidoException
	 */
	public Usuario(String nome, String login) throws NomeInvalidoException, LoginInvalidoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new NomeInvalidoException("Usuario");
		}
		if (login == null || login.trim().isEmpty()) {
			throw new LoginInvalidoException();
		}
		this.nome = nome;
		this.login = login;
		this.saldo = 0;
		this.x2p = 0;
		this.listaDeJogos = new ArrayList<Jogo>();
	}

	/**
	 * Metodo abstrato que compra um jogo para ser adicionado na biblioteca do
	 * usuario.
	 * 
	 * @param jogo
	 *            - recebe o jogo a ser adicionado;
	 * @return
	 * @throws JogoInvalidoException,
	 *             SaldoInsuficienteException - gera um exception caso o jogo
	 *             seja invalido ou o saldo seja insuficiente;
	 */

	public abstract void compraJogo(Jogo jogo) throws JogoInvalidoException, SaldoInsuficienteException;

	/**
	 * Metodo abstrato que calcula o desconto do jogo de acordo com o tipo de
	 * usuario.
	 * 
	 * @param jogo
	 *            - recebe o jogo;
	 * @return - retorna o desconto;
	 */
	protected abstract double desconto(Jogo jogo);

	/**
	 * Metodo abstrato que calcula o x2p recebido apos a compra de acordo com o
	 * tipo de usuario;
	 * 
	 * @param jogo
	 *            - recebe o nome do jogo;
	 */
	protected abstract int x2pPorCompra(Jogo jogo);

	/**
	 * Esse metodo adiciona um jogo na biblioteca de jogos do usuario
	 * 
	 * @param jogo
	 *            - recebe o jogo a ser adicionado;
	 * @return
	 */
	public void addJogo(Jogo jogo) {
		this.listaDeJogos.add(jogo);
	}

	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws JogoInvalidoException, Exception {
		if (nomeDoJogo == null || nomeDoJogo.trim().isEmpty()) {
			throw new JogoInvalidoException();
		}
		Jogo jogo = buscaJogo(nomeDoJogo);
		this.x2p += jogo.registraJogada(score, zerou);

	}

	/**
	 * metodo para busca um jogo na lista de jodos da loja
	 * 
	 * @param nomeDoJogo
	 * @return
	 */
	public Jogo buscaJogo(String nomeDoJogo) {
		for (Jogo jogo : listaDeJogos) {
			if (nomeDoJogo.equalsIgnoreCase(jogo.getNome())) {
				return jogo;
			}

		}
		return null;
	}

	/**
	 * metodo para calcular o preco total gasto com jogos
	 * 
	 * @return
	 */
	public String totalGastoNaStreem() {
		double total = 0;
		for (Jogo jogo : listaDeJogos) {
			total += jogo.getPreco();
		}

		return "R$ " + total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * total de jogos comprados pelo usuario
	 * 
	 * @return
	 */
	public int totalJogosComprados() {
		return this.listaDeJogos.size();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new NomeInvalidoException("Usuario");
		}
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) throws LoginInvalidoException {
		if (login == null || login.trim().isEmpty()) {
			throw new LoginInvalidoException();
		}
		this.login = login;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	public ArrayList<Jogo> getListaDeJogos() {
		return listaDeJogos;
	}

	public void setListaDeJogos(ArrayList<Jogo> listaDeJogos) {
		this.listaDeJogos = listaDeJogos;
	}

}
