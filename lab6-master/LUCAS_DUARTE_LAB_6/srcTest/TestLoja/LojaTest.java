package TestLoja;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Jogo.Jogabilidade;
import Jogo.Jogo;
import Jogo.Luta;
import Jogo.Plataforma;
import Jogo.Rpg;
import usuario.Noob;
import usuario.Usuario;
import Loja.Fachada;
import excecoes.JogoInvalidoException;
import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.SaldoInsuficienteException;
import excecoes.UpgradeInvalidoException;
import excecoes.UsuarioInvalidoException;

public class LojaTest {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	private Fachada loja;
	private String fifa = "fifa";
	private String login = "lucasvd";
	private String cs = "cs-go";

	@Before
	public void setUp() throws Exception {
		this.loja = new Fachada();
		this.loja.addUsuario("lucas", login);
	}

	@Test
	public void testAddERemoveUsuario() throws Exception {
		loja.addUsuario("thays", "thay");
		loja.addUsuario("lucasDuarte", "lucasd");
		Assert.assertEquals(3, loja.qtdUsuario());
		loja.removeUsuario("lucasd");
		Assert.assertNotEquals(3, loja.qtdUsuario());
		Assert.assertEquals(2, loja.qtdUsuario());

	}

	@Test
	public void testeAddSaldo() {

		Assert.assertEquals(1, loja.qtdUsuario());
		Assert.assertEquals(0, loja.confereCredito(login), 0.01);

		loja.addDinheiro(login, 200);
		Assert.assertEquals(200, loja.confereCredito(login), 0.01);

	}

	@Test
	public void testUpgrade() throws Exception {
		loja.addDinheiro(login, 1000);
		Assert.assertEquals(1000, loja.confereCredito(login), 0.1);

		loja.vendeJogo(fifa, 100, "rpg", "online offline", login);
		Assert.assertEquals(910, loja.confereCredito(login), 0.1);
		Assert.assertEquals(1000, loja.confereX2p(login));
		// passar pra veterano
		loja.upgrad(login);

		loja.vendeJogo(cs, 10, "plataforma", "online", login);
		Assert.assertNotEquals(901, loja.confereCredito(login), 0.1);
		// desconto como veterano
		Assert.assertEquals(902, loja.confereCredito(login), 0.1);

	}

	@Test
	public void testToString() throws UsuarioInvalidoException {
		Assert.assertEquals("=== Central P2-CG ===" + FIM_DE_LINHA + FIM_DE_LINHA + "lucasvd" + FIM_DE_LINHA
				+ "lucas - Jogador Noob" + FIM_DE_LINHA + "Lista de Jogos:" + FIM_DE_LINHA + FIM_DE_LINHA +

				"Total de preco dos jogos: R$ 0.0" + FIM_DE_LINHA + FIM_DE_LINHA, loja.toString());
	}

}
