package usuario;

import java.util.ArrayList;

import Jogo.Jogo;
import excecoes.JogoInvalidoException;
import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.SaldoInsuficienteException;

public class Usuario {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	private String nome;
	private String login;
	private double saldo;
	protected int x2p;
	private ArrayList<Jogo> listaDeJogos;
	private TipoDeUsuarioIF tipoDeUsuarioIF;

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
		this.tipoDeUsuarioIF = new Noob();
	}

	/**
	 * O metodo compraJogo inicializa so como uma variavel para q um usuario
	 * possa fazer a compra de um jogo
	 * 
	 * @param jogo
	 * @throws ValorInvalidoException
	 */
	public void compraJogo(Jogo jogo) throws SaldoInsuficienteException {
		upgrade();
		downgrade();
		double custo = this.tipoDeUsuarioIF.desconto(jogo.getPreco());

		if (custo > this.getSaldo()) {
			throw new SaldoInsuficienteException();
		} else {
			int parteInteira = (int) (jogo.getPreco() - (jogo.getPreco() % 1));
			setX2p(getX2p() + this.tipoDeUsuarioIF.x2p(parteInteira));
			setSaldo(getSaldo() - custo);
			this.addJogo(jogo);

		}
	}

	/**
	 * metodo para um usuario noob se torna veterano dependendo do seu x2p
	 */
	public void upgrade() {
		if (this.getX2p() >= 1000) {
			this.tipoDeUsuarioIF = new Veterano();
		}
	}

	/**
	 * metodo para um veterano noob se torna noob dependendo do seu x2p
	 */
	public void downgrade() {
		if (this.getX2p() < 1000) {
			this.tipoDeUsuarioIF = new Noob();
		}
	}

	/**
	 * metodo para recompensar com x2p o usuario dependendo do estilo de jogo e
	 * dependendeo do tipo de usuario que ele for
	 * 
	 * @param nomeJogo
	 * @param scoreObtido
	 * @param zerou
	 * @throws Exception
	 * @throws StringInvalidaException
	 */
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou) throws Exception {
		Jogo jogo = this.buscaJogo(nomeJogo);
		this.setX2p(getX2p() + jogo.registraJogada(scoreObtido, zerou) + this.tipoDeUsuarioIF.recompensar(jogo));
	}

	/**
	 * metodo para punir com x2p o usuario dependendo do estilo de jogo e
	 * dependendeo do tipo de usuario que ele for
	 * 
	 * @param nomeJogo
	 * @param scoreObtido
	 * @param zerou
	 * @throws Exception
	 * @throws StringInvalidaException
	 */
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) throws Exception {
		Jogo jogo = this.buscaJogo(nomeJogo);
		this.setX2p(getX2p() + jogo.registraJogada(scoreObtido, zerou) + this.tipoDeUsuarioIF.punir(jogo));
	}

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

	public double totalGasto() {
		double total = 0;
		for (Jogo jogo : listaDeJogos) {
			total += jogo.getPreco();
		}

		return total;
	}

	public String toString() {
		String resultado = this.nome + "-" + this.login + "-" + tipoDeUsuarioIF;
		return resultado;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaDeJogos == null) ? 0 : listaDeJogos.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipoDeUsuarioIF == null) ? 0 : tipoDeUsuarioIF.hashCode());
		result = prime * result + x2p;
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
		if (listaDeJogos == null) {
			if (other.listaDeJogos != null)
				return false;
		} else if (!listaDeJogos.equals(other.listaDeJogos))
			return false;
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
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		if (tipoDeUsuarioIF == null) {
			if (other.tipoDeUsuarioIF != null)
				return false;
		} else if (!tipoDeUsuarioIF.equals(other.tipoDeUsuarioIF))
			return false;
		if (x2p != other.x2p)
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
