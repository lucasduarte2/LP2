package Loja;

import java.awt.print.Printable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Jogo.FactoryJogo;
import Jogo.Jogabilidade;
import Jogo.Jogo;
import easyaccept.EasyAccept;
import excecoes.EstiloInvalidoException;
import excecoes.JogoInvalidoException;
import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.PrecoInvalidoException;
import excecoes.SaldoInsuficienteException;
import excecoes.UpgradeInvalidoException;
import excecoes.UsuarioInvalidoException;
import usuario.FactoryUsuario;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class LojaController {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	private ArrayList<Usuario> listaUsuarios;
	private FactoryUsuario usuarioFactory;
	private HashMap<String, Jogabilidade> jogabilidade;
	private FactoryJogo jogoFactory;

	/**
	 * construtor da fachada que inicializaq os objetos
	 */
	public LojaController() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuarioFactory = new FactoryUsuario();
		this.jogoFactory = new FactoryJogo();
		this.iniciaMap();
	}

	/**
	 * Metodo que adiciona usuario na loja
	 * 
	 * @param nome
	 * @param loginUsuario
	 * @throws Exception
	 */
	public void criaUsuario(String nome, String loginUsuario, String tipoUsuario) throws Exception {
		try {
			Usuario usuario = usuarioFactory.criaUsuario(nome, loginUsuario, tipoUsuario);
			listaUsuarios.add(usuario);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que remove um usuario
	 * 
	 * @param nome
	 * @param loginUsuario
	 * @throws UsuarioInvalidoException
	 * @throws LoginInvalidoException
	 */
	public void removeUsuario(String loginUsuario) throws UsuarioInvalidoException, LoginInvalidoException {
		try {
			Usuario usuario = buscaUsuario(loginUsuario);
			listaUsuarios.remove(usuario);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Esse metodo adiciona dinheiro a conta do usuario
	 * 
	 * @param loginUsuario
	 * @param valor
	 * @throws SaldoInsuficienteException
	 * @throws LoginInvalidoException
	 */
	public void adicionaCredito(String loginUsuario, double valor) {
		try {
			if (valor < 0) {
				throw new SaldoInsuficienteException("Valor nao pode ser negativo");
			}
			Usuario usuario = buscaUsuario(loginUsuario);
			usuario.setSaldo(usuario.getSaldo() + valor);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Esse metodo verifica se um usuario existe na loja atravez do login do
	 * mesmo
	 * 
	 * @param loginUsuario
	 * @return
	 * @throws LoginInvalidoException
	 */
	public Usuario buscaUsuario(String loginUsuario) throws LoginInvalidoException {

		for (Usuario usuario : listaUsuarios) {
			if (usuario.getLogin().equals(loginUsuario)) {
				return usuario;
			}
		}

		throw new LoginInvalidoException();
	}

	/**
	 * Metodo para recompensar um usuario
	 * 
	 * @param loginUsuario
	 * @param nomeJogo
	 * @param scoreObtido
	 * @param zerou
	 * @throws Exception
	 */
	public void recompensar(String loginUsuario, String nomeJogo, int scoreObtido, boolean zerou) throws Exception {
		try {
			Usuario usuario = this.buscaUsuario(loginUsuario);
			usuario.recompensar(nomeJogo, scoreObtido, zerou);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo para punir um usuario
	 * 
	 * @param login
	 * @param nomeJogo
	 * @param scoreObtido
	 * @param zerou
	 * @throws Exception
	 * @throws StringInvalidaException
	 */
	public void punir(String loginUsuario, String nomeJogo, int scoreObtido, boolean zerou) throws Exception {
		try {
			Usuario usuario = this.buscaUsuario(loginUsuario);
			usuario.punir(nomeJogo, scoreObtido, zerou);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo para fazer o upgrade do usuario
	 * 
	 * @param login
	 * @throws LoginInvalidoException
	 * @throws StringInvalidaException
	 */
	public void upgrade(String login) throws LoginInvalidoException {
		try {
			Usuario antigo = this.buscaUsuario(login);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Metodo para fazer o downgrade do usuario
	 * 
	 * @param login
	 * @throws StringInvalidaException
	 */
	public void downgrade(String login) throws LoginInvalidoException {
		try {
			Usuario antigo = this.buscaUsuario(login);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Esse metodo vende um jogo ao usuario
	 * 
	 * @param nome
	 * @param preco
	 * @param estilo
	 * @param jogabilidades
	 * @param loginUsuario
	 */
	public void vendeJogo(String nome, double preco, String jogabilidades, String estilo, String loginUsuario) {
		try {
			Usuario usuario = buscaUsuario(loginUsuario);
			HashSet<Jogabilidade> jogabilidade = addJogabilidade(jogabilidades);
			Jogo jogo = criaJogo(nome, preco, jogabilidade, estilo);
			usuario.compraJogo(jogo);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Metodo que confere o saldo do usuario
	 * 
	 * @param loginUsuario
	 * @return
	 */
	public double confereCredito(String loginUsuario) {
		try {
			Usuario usuario = this.buscaUsuario(loginUsuario);
			return usuario.getSaldo();
		} catch (LoginInvalidoException e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}

	/**
	 * Metodo que confere o x2p do usuario
	 * 
	 * @param loginUsuario
	 * @return
	 * @throws LoginInvalidoException
	 */
	public int getX2p(String loginUsuario) throws LoginInvalidoException {
		Usuario usuario = this.buscaUsuario(loginUsuario);
		return usuario.getX2p();

	}

	/**
	 * Esse metodo cria um jogo para ser comprado
	 * 
	 * @param nome
	 * @param preco
	 * @param estilo
	 * @param jogabilidades
	 * @return
	 */
	private Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades, String estilo) {
		try {

			Jogo jogo = jogoFactory.criaJogo(nome, preco, jogabilidades, estilo);
			return jogo;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;

	}

	/**
	 * metodo que retorna A arrecadacao da Streem
	 * 
	 * @return
	 */
	private double ArrecadacaoStreem() {
		double total = 0;
		for (Usuario usuario : listaUsuarios) {
			total += usuario.totalGasto();
		}
		return total;
	}

	/**
	 * Esse metodo adiciona uma jogabilidade a um determinado jogo
	 * 
	 * @param jogabilidades
	 * @return
	 */
	private HashSet<Jogabilidade> addJogabilidade(String jogabilidades) {
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		String[] nomesJogabilidades = jogabilidades.split(" ");

		for (String nomes : nomesJogabilidades) {
			String nomeJogabilidade = nomes.toUpperCase();
			if (nomeJogabilidade != null) {
				Jogabilidade jogabilidade1 = this.jogabilidade.get(nomeJogabilidade);
				jogabilidade.add(jogabilidade1);
			}
		}
		return jogabilidade;

	}

	/**
	 * Metodo que mostra a quantidade de usuario na loja
	 * 
	 * @return
	 */
	public int qtdUsuario() {
		return this.listaUsuarios.size();
	}

	@Override
	public String toString() {
		String resultado = "=== Central P2-CG ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		for (int i = 0; i < listaUsuarios.size(); i++) {
			resultado += listaUsuarios.get(i).toString() + FIM_DE_LINHA;
		}
		return resultado;
	}

	/**
	 * metodo que inicializa o mapa de jogabilidade
	 */
	private void iniciaMap() {
		this.jogabilidade = new HashMap<>();
		jogabilidade.put("ONLINE", Jogabilidade.ONLINE);
		jogabilidade.put("OFFLINE", Jogabilidade.OFFLINE);
		jogabilidade.put("COMPETITIVO", Jogabilidade.COMPETITIVO);
		jogabilidade.put("COOPERATIVO", Jogabilidade.COOPERATIVO);
		jogabilidade.put("MULTIPLAYER", Jogabilidade.MULTIPLAYER);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaUsuarios == null) ? 0 : listaUsuarios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LojaController))
			return false;
		LojaController other = (LojaController) obj;
		if (listaUsuarios == null) {
			if (other.listaUsuarios != null)
				return false;
		} else if (!listaUsuarios.equals(other.listaUsuarios))
			return false;
		return true;
	}

}
