package TestJogo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Jogo.Jogo;
import Jogo.Rpg;
import excecoes.NomeInvalidoException;
import excecoes.PontuacaoInvalidaException;
import excecoes.PrecoInvalidoException;

public class JogoRpgTest {

	private Jogo rpg;
	public static final String FIM_DE_LINHA = System.lineSeparator();

	@Before
	public void setUp() throws Exception {
		this.rpg = new Rpg("rpg", 100);
	}

	@Test
	public void testCriaJogo() {
		try {
			Jogo rpg = new Rpg("rpg", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCriaJogoException() {
		try {
			Jogo rpg = new Rpg(null, 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			assertEquals("Nome do jogo invalido", e.getMessage());
		}

		try {
			Jogo rpg = new Rpg(" ", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			assertEquals("Nome do jogo invalido", e.getMessage());
		}

		try {
			Jogo rpg = new Rpg("rpg", -1);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			assertEquals("Preco Invalido", e.getMessage());
		}

	}

	@Test
	public void testRegistraJogada() throws Exception {

		Assert.assertEquals(10, rpg.registraJogada(10000, true));
		Assert.assertEquals(10000, rpg.getMaiorScore());
		Assert.assertEquals(1, rpg.getVezesZeradas());
		Assert.assertEquals(1, rpg.getQuantidadeJogada());

		Assert.assertEquals(10, rpg.registraJogada(9999, true));
		Assert.assertEquals(10000, rpg.getMaiorScore());
		Assert.assertEquals(2, rpg.getVezesZeradas());
		Assert.assertEquals(2, rpg.getQuantidadeJogada());

		Assert.assertEquals(10, rpg.registraJogada(1000, false));
		Assert.assertEquals(10000, rpg.getMaiorScore());
		Assert.assertEquals(2, rpg.getVezesZeradas());
		Assert.assertEquals(3, rpg.getQuantidadeJogada());

		Assert.assertEquals(10, rpg.registraJogada(100000, false));
		Assert.assertEquals(100000, rpg.getMaiorScore());
		Assert.assertEquals(2, rpg.getVezesZeradas());
		Assert.assertEquals(4, rpg.getQuantidadeJogada());

	}

	@Test
	public void testPontuacaoInvalida() throws Exception {
		try {
			rpg.registraJogada(-1, true);
		} catch (PontuacaoInvalidaException e) {
			assertEquals("pontuacao invalida", e.getMessage());
		}
	}

	@Test
	public void TestToString() throws Exception {
		Assert.assertEquals(10, rpg.registraJogada(10000, true));
		Assert.assertEquals(10000, rpg.getMaiorScore());
		Assert.assertEquals(1, rpg.getVezesZeradas());
		Assert.assertEquals(1, rpg.getQuantidadeJogada());

		Assert.assertEquals("rpg - Rpg:" + FIM_DE_LINHA + "==> Jogou " + rpg.getQuantidadeJogada() + " vez(es)"
				+ FIM_DE_LINHA + "==> Zerou " + rpg.getVezesZeradas() + " vez(es)" + FIM_DE_LINHA + "==> Maior Score: "
				+ rpg.getMaiorScore() + FIM_DE_LINHA, rpg.toString());
	}

}
