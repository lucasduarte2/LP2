package UsuarioTest;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Jogo.Jogo;
import Jogo.Luta;
import excecoes.NomeInvalidoException;
import excecoes.PrecoInvalidoException;
import excecoes.SaldoInsuficienteException;
import usuario.Usuario;

public class UsuarioTest {

	private Usuario usuario;
	private String lucas = "lucas";
	private String login = "lucasvd";

	@Before
	public void setUp() throws Exception {
		this.usuario = new Usuario(lucas, login);
	}

	@Test
	public void UsuarioExeption() {
		try {
			Usuario usuario = new Usuario(null, login);
		} catch (Exception e) {
			assertEquals("Nome do Usuario invalido", e.getMessage());
		}

		try {
			Usuario usuario = new Usuario("", login);
		} catch (Exception e) {
			assertEquals("Nome do Usuario invalido", e.getMessage());
		}

		try {
			Usuario usuario = new Usuario(lucas, null);
		} catch (Exception e) {
			assertEquals("Login invalido", e.getMessage());
		}
		try {
			Usuario usuario = new Usuario(lucas, "");
		} catch (Exception e) {
			assertEquals("Login invalido", e.getMessage());
		}
	}

	@Test
	public void compramTest() throws NomeInvalidoException, PrecoInvalidoException, SaldoInsuficienteException {
		Jogo jogo = new Luta("luta", 100);
		usuario.setSaldo(1000);
		this.usuario.compraJogo(jogo);
		Assert.assertNotEquals(0, usuario.totalJogosComprados());
		Assert.assertEquals(1, usuario.totalJogosComprados());
		Assert.assertEquals(910, usuario.getSaldo(), 0.1);
		Assert.assertEquals(1000, usuario.getX2p());
		Assert.assertEquals("R$ 100.0", usuario.totalGastoNaStreem());
		Assert.assertEquals(100.0, usuario.totalGasto(), 0.01);

	}

}
