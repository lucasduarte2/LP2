package testUsuario;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Jogo.*;
import Loja.Fachada;
import excecoes.*;
import usuario.*;

public class UsuarioVeteranoTest {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	private Usuario lucas;
	private Jogo cs;
	private Jogo fifa;
	private Jogo StreetFighter;

	@Before
	public void setUp() throws Exception {
		this.lucas = new Veterano("lucas", "lucasvd");
		this.cs = new Rpg("counter strike", 50);
		this.fifa = new Plataforma("fifa", 200);
		this.StreetFighter = new Luta("Street Fighter", 10);
	}

	@Test
	public void testCriaUsuario() {
		try {
			Usuario lucas = new Veterano("lucas", "lucasvd");
		} catch (NomeInvalidoException | LoginInvalidoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCriaUsuarioException() {
		try {
			Usuario lucas = new Veterano("lucas", null);
		} catch (NomeInvalidoException | LoginInvalidoException e) {
			assertEquals("Login invalido", e.getMessage());
		}

		try {
			Usuario lucas = new Veterano("lucas", "");
		} catch (NomeInvalidoException | LoginInvalidoException e) {
			assertEquals("Login invalido", e.getMessage());
		}

		try {
			Usuario lucas = new Veterano(null, "lucasvd");
		} catch (NomeInvalidoException | LoginInvalidoException e) {
			assertEquals("Nome do Usuario invalido", e.getMessage());
		}

		try {
			Usuario lucas = new Veterano("", "lucasvd");
		} catch (NomeInvalidoException | LoginInvalidoException e) {
			assertEquals("Nome do Usuario invalido", e.getMessage());
		}
	}

	@Test
	public void testCompraJogo() throws JogoInvalidoException, SaldoInsuficienteException {
		lucas.setSaldo(250);
		Assert.assertEquals(250, lucas.getSaldo(), 0.1);
		lucas.compraJogo(cs);
		// preco sem desconto
		Assert.assertNotEquals(200, lucas.getSaldo(), 0.1);
		// preco com o desconto
		Assert.assertEquals(210, lucas.getSaldo(), 0.1);

	}

	@Test
	public void testSaldoException() {

		try {
			lucas.compraJogo(cs);
		} catch (JogoInvalidoException | SaldoInsuficienteException e) {
			assertEquals("Saldo insuficiente para realizar a compra", e.getMessage());
		}
	}

	@Test
	public void testX2p() throws JogoInvalidoException, SaldoInsuficienteException {
		lucas.setSaldo(250);
		lucas.compraJogo(cs);
		Assert.assertEquals(1750, lucas.getX2p());

		lucas.compraJogo(StreetFighter);
		Assert.assertNotEquals(500, lucas.getX2p());
		Assert.assertEquals(1900, lucas.getX2p());

	}

	@Test
	public void TotalGasto() throws JogoInvalidoException, SaldoInsuficienteException {
		lucas.setSaldo(250);
		lucas.compraJogo(cs);
		lucas.compraJogo(StreetFighter);
		Assert.assertEquals("R$ 60.0", lucas.totalGastoNaStreem());
		Assert.assertEquals(2, lucas.totalJogosComprados());

	}

	@Test
	public void testX2P()
			throws JogoInvalidoException, SaldoInsuficienteException, NomeInvalidoException, PrecoInvalidoException {
		lucas.setSaldo(250);
		Assert.assertEquals(250, lucas.getSaldo(), 0.1);
		lucas.compraJogo(cs);
		Assert.assertEquals(1750, lucas.getX2p());

		lucas.setSaldo(lucas.getSaldo() + 1000);
		Assert.assertEquals(1210.0, lucas.getSaldo(), 0.1);

		Jogo fifa17 = new Plataforma("fifa17", 500);
		lucas.compraJogo(fifa17);
		Assert.assertEquals(810, lucas.getSaldo(), 0.1);

	}

	@Test
	public void testToString() {
		Assert.assertEquals(
				"lucasvd" + FIM_DE_LINHA + "lucas - Jogador Veterano" + FIM_DE_LINHA + "Lista de Jogos:" + FIM_DE_LINHA
						+ FIM_DE_LINHA + "Total de preco dos jogos: " + lucas.totalGastoNaStreem() + FIM_DE_LINHA,
				lucas.toString());
	}

}
