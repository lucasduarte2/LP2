package Loja;

import java.awt.print.Printable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Jogo.FactoryJogo;
import Jogo.Jogabilidade;
import Jogo.Jogo;
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

public class Fachada {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	private ArrayList<Usuario> listaUsuarios;
	private FactoryUsuario usuarioFactory;
	private HashMap<String, Jogabilidade> jogabilidade;
	private FactoryJogo jogoFactory;

	/**
	 * construtor da fachada que inicializaq os objetos
	 */
	public Fachada() {
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
	public void addUsuario(String nome, String loginUsuario) throws Exception {
		try {
			Usuario usuario = usuarioFactory.criaUsuario(nome, loginUsuario, "Noob");
			listaUsuarios.add(usuario);
		} catch (NomeInvalidoException | LoginInvalidoException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Metodo que remove um usuario
	 * 
	 * @param nome
	 * @param loginUsuario
	 * @throws UsuarioInvalidoException
	 */
	public void removeUsuario(String loginUsuario) throws UsuarioInvalidoException {
		try {
			Usuario usuario = pesquisaUsuario(loginUsuario);
			listaUsuarios.remove(usuario);
		} catch (LoginInvalidoException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Esse metodo adiciona dinheiro a conta do usuario
	 * 
	 * @param loginUsuario
	 * @param valor
	 */
	public void addDinheiro(String loginUsuario, double valor) {
		try {
			if (valor < 0) {
				throw new SaldoInsuficienteException("Valor nao pode ser negativo");
			}
			Usuario usuario = pesquisaUsuario(loginUsuario);
			usuario.setSaldo(usuario.getSaldo() + valor);

		} catch (SaldoInsuficienteException | LoginInvalidoException e) {
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
	private Usuario pesquisaUsuario(String loginUsuario) throws LoginInvalidoException {
		try {
			for (Usuario usuario : listaUsuarios) {
				if (usuario.getLogin().equalsIgnoreCase(loginUsuario)) {
					return usuario;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		throw new LoginInvalidoException();
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
	public void vendeJogo(String nome, double preco, String estilo, String jogabilidades, String loginUsuario) {
		try {
			Usuario usuario = pesquisaUsuario(loginUsuario);
			HashSet<Jogabilidade> jogabilidade = addJogabilidade(jogabilidades);
			Jogo jogo = criaJogo(nome, preco, estilo, jogabilidade);
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
			Usuario usuario = this.pesquisaUsuario(loginUsuario);
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
	public int confereX2p(String loginUsuario) throws LoginInvalidoException {
		try {
			Usuario usuario = pesquisaUsuario(loginUsuario);
			return usuario.getX2p();

		} catch (LoginInvalidoException e) {
			System.err.println(e.getMessage());
		}
		return 0;
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
	public Jogo criaJogo(String nome, double preco, String estilo, HashSet<Jogabilidade> jogabilidades) {
		try {

			Jogo jogo = jogoFactory.criaJogo(nome, preco, jogabilidades, estilo);
			return jogo;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;

	}

	/**
	 * Esse metodo faz o upgrade de usuarios(Noob para veterano)
	 * 
	 * @param loginUsuario
	 * @throws Exception
	 */
	public void upgrad(String loginUsuario) throws Exception {

		Usuario usuarioAntigo = pesquisaUsuario(loginUsuario);
		if (usuarioAntigo instanceof Veterano) {
			throw new UpgradeInvalidoException();
		}
		if (usuarioAntigo.getX2p() < 1000) {
			throw new UpgradeInvalidoException();
		}

		Usuario novo = usuarioFactory.criaUsuario(usuarioAntigo.getNome(), usuarioAntigo.getLogin(), "Veterano");
		novo.setSaldo(usuarioAntigo.getSaldo());
		novo.setX2p(usuarioAntigo.getX2p());
		novo.setListaDeJogos(usuarioAntigo.getListaDeJogos());
		int index = this.listaUsuarios.indexOf(usuarioAntigo);
		this.listaUsuarios.add(index, novo);

	}

	/**
	 * Esse metodo adiciona uma jogabilidade a um determinado jogo
	 * 
	 * @param jogabilidades
	 * @return
	 */
	private HashSet<Jogabilidade> addJogabilidade(String jogabilidades) {
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		String[] nomesJogabilidades = jogabilidades.split(",");

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
		if (!(obj instanceof Fachada))
			return false;
		Fachada other = (Fachada) obj;
		if (listaUsuarios == null) {
			if (other.listaUsuarios != null)
				return false;
		} else if (!listaUsuarios.equals(other.listaUsuarios))
			return false;
		return true;
	}

}
