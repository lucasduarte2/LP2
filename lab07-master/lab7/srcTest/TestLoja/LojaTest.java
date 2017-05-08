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
import Loja.LojaController;
import excecoes.JogoInvalidoException;
import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.SaldoInsuficienteException;
import excecoes.UpgradeInvalidoException;
import excecoes.UsuarioInvalidoException;

public class LojaTest {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	private LojaController loja;
	private String fifa = "fifa";
	private String login = "lucasvd";
	private String cs = "cs-go";
	private String Noob = "Noob";

	@Before
	public void setUp() throws Exception {
		this.loja = new LojaController();
		this.loja.criaUsuario("lucas", login, Noob);
	}

	@Test
	public void testAddERemoveUsuario() throws Exception {
		loja.criaUsuario("thays", "thay", Noob);
		loja.criaUsuario("lucasDuarte", "lucasd", Noob);
		Assert.assertEquals(3, loja.qtdUsuario());
		loja.removeUsuario("lucasd");
		Assert.assertNotEquals(3, loja.qtdUsuario());
		Assert.assertEquals(2, loja.qtdUsuario());

	}

	@Test
	public void testeAddSaldo() {

		Assert.assertEquals(1, loja.qtdUsuario());
		Assert.assertEquals(0, loja.confereCredito(login), 0.01);

		loja.adicionaCredito(login, 200);
		Assert.assertEquals(200, loja.confereCredito(login), 0.01);

	}

	@Test
	public void testUpgrade() throws Exception {
		loja.adicionaCredito(login, 1000);
		Assert.assertEquals(1000, loja.confereCredito(login), 0.1);

		loja.vendeJogo(fifa, 100, "online offline", "rpg", login);
		Assert.assertEquals(910, loja.confereCredito(login), 0.1);
		Assert.assertEquals(1000, loja.getX2p(login));
		//usuario passa a ser veterano
		loja.vendeJogo(cs, 10, "online", "plataforma", login);
		//desconto veterano
		Assert.assertEquals(902, loja.confereCredito(login), 0.1);
	
	}
	
	
	
	@Test
	public void downgrade() throws Exception {
		loja.adicionaCredito(login, 1000);
		loja.vendeJogo(fifa, 100, "online offline", "rpg", login);
		Assert.assertEquals(1000, loja.getX2p(login));
		//usuario passa a ser veterano
		loja.vendeJogo(cs, 2, "online", "plataforma", login);
		//desconto veterano
		Assert.assertEquals(908.4, loja.confereCredito(login), 0.1);
		Assert.assertEquals(1030, loja.getX2p(login));
		loja.punir(login, fifa, 1000, false);
		loja.punir(login, fifa, 100, false);
		loja.punir(login, fifa, 100, false);
		loja.punir(login, fifa, 10, false);
		loja.punir(login, fifa, 10, false);
		Assert.assertEquals(980, loja.getX2p(login));
		loja.adicionaCredito(login, 1.6);
		Assert.assertEquals(910, loja.confereCredito(login), 0.1);
		//usuario volta a ser noob
		loja.vendeJogo(cs, 10, "online", "plataforma", login);
		//desconto noob
		Assert.assertEquals(901, loja.confereCredito(login), 0.1);
		loja.recompensar(login, fifa, 10000, true);
		Assert.assertEquals(1120, loja.getX2p(login));
		
	
	}

}
