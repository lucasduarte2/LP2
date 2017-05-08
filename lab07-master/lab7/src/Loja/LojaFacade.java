package Loja;

import easyaccept.EasyAccept;
import excecoes.LoginInvalidoException;
import excecoes.UsuarioInvalidoException;
import usuario.Usuario;

public class LojaFacade {

	private LojaController lojaController;

	public LojaFacade() {
		this.lojaController = new LojaController();
	}

	/**
	 * Metodo que cria um usuario
	 * 
	 * @param nome
	 * @param login
	 * @param tipoUsuario
	 * @throws Exception
	 */
	public void criaUsuario(String nome, String login, String tipoUsuario) throws Exception {
		this.lojaController.criaUsuario(nome, login, tipoUsuario);

	}

	/**
	 * Metodo que remove um usuario
	 * 
	 * @param loginUsuario
	 * @throws UsuarioInvalidoException
	 * @throws LoginInvalidoException
	 */
	public void removeUsuario(String loginUsuario) throws UsuarioInvalidoException, LoginInvalidoException {
		this.lojaController.removeUsuario(loginUsuario);
	}

	/**
	 * Metodo que vende um jogo a um usuario
	 * 
	 * @param jogoNome
	 * @param preco
	 * @param jogabilidades
	 * @param estiloJogo
	 * @param loginUser
	 */
	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser) {
		this.lojaController.vendeJogo(jogoNome, preco, jogabilidades, estiloJogo, loginUser);
	}

	/**
	 * Metodo que recompensa um usuario
	 * 
	 * @param login
	 * @param nomeJogo
	 * @param scoreObtido
	 * @param zerou
	 * @throws Exception
	 */
	public void recompensar(String login, String nomeJogo, int scoreObtido, boolean zerou) throws Exception {
		this.lojaController.recompensar(login, nomeJogo, scoreObtido, zerou);

	}

	/**
	 * Metodo que puni um usuario
	 * 
	 * @param login
	 * @param nomeJogo
	 * @param scoreObtido
	 * @param zerou
	 * @throws Exception
	 */
	public void punir(String login, String nomeJogo, int scoreObtido, boolean zerou) throws Exception {
		this.lojaController.punir(login, nomeJogo, scoreObtido, zerou);

	}

	/**
	 * Metodo que adiciona credito na conta de um usuario
	 * 
	 * @param login
	 * @param credito
	 */
	public void adicionaCredito(String login, double credito) {
		this.lojaController.adicionaCredito(login, credito);
	}

	/**
	 * Metodo que busca um usuario na lista da Streem
	 * 
	 * @param login
	 * @return
	 * @throws LoginInvalidoException
	 */
	public Usuario buscaUsuario(String login) throws LoginInvalidoException {
		return this.lojaController.buscaUsuario(login);
	}

	/**
	 * Metodo de upgrade de faz um usuario passar a ser veterano
	 * 
	 * @param login
	 * @throws LoginInvalidoException
	 */
	public void upgrade(String login) throws LoginInvalidoException {
		this.lojaController.upgrade(login);

	}

	/**
	 * Metodo de downgrade de faz um usuario passar a ser noob
	 * 
	 * @param login
	 * @throws LoginInvalidoException
	 */
	public void downgrade(String login) throws LoginInvalidoException {
		this.lojaController.downgrade(login);

	}

	/**
	 * Metodo que confere credito de um usuario
	 * 
	 * @param login
	 * @return
	 */
	public double confereCredito(String login) {
		return this.lojaController.confereCredito(login);
	}

	/**
	 * metodo que da uma informacao dos usuarios da Streem
	 * 
	 * @return
	 */
	public String informacaoUsuarios() {
		return this.lojaController.toString();
	}

	/**
	 * metodo que da o x2p de um usuario
	 * 
	 * @param login
	 * @return
	 * @throws LoginInvalidoException
	 */
	public int getX2p(String loginUsuario) throws LoginInvalidoException {
		return this.lojaController.getX2p(loginUsuario);
	}

	public static void main(String[] args) {
		args = new String[] { "Loja.LojaController", "acceptance_test/us1.txt", "acceptance_test/us2.txt",
				"acceptance_test/us3.txt" };
		EasyAccept.main(args);

	}
}
