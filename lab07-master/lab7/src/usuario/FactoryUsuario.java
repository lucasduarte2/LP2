package usuario;

import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.UsuarioInvalidoException;

public class FactoryUsuario {
	/**
	 * Esse metodo cria um usuario Noob
	 * 
	 * @param nome
	 * @param loginUsuario
	 * @return
	 * @throws Exception
	 */
	public Usuario criaUsuario(String nome, String loginUsuario, String tipoUsuario) throws Exception {

		Usuario novoUsuario;
		
		if (nome == null || nome.trim().isEmpty()) {
			throw new NomeInvalidoException("Usuario");
		}
		if (loginUsuario == null || loginUsuario.trim().isEmpty()) {
			throw new LoginInvalidoException();
		}else {
			novoUsuario = new Usuario(nome, loginUsuario);
		}
		return novoUsuario;
		
	}

}
