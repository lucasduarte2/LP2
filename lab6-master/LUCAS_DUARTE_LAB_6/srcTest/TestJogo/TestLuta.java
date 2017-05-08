package TestJogo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Jogo.Jogo;
import Jogo.Luta;
import excecoes.NomeInvalidoException;
import excecoes.PontuacaoInvalidaException;
import excecoes.PrecoInvalidoException;

public class TestLuta {

	private Jogo luta;
	public static final String FIM_DE_LINHA = System.lineSeparator();

	@Before
	public void setUp() throws Exception {
		this.luta = new Luta("luta", 100);
	}

	@Test
	public void testCriaJogo() {
		try {
			Jogo luta = new Luta("luta", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCriaJogoException() {
		try {
			Jogo luta = new Luta("luta", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			assertEquals("Nome do jogo invalido", e.getMessage());
		}

		try {
			Jogo luta = new Luta("luta", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			assertEquals("Nome do jogo invalido", e.getMessage());
		}

		try {
			Jogo luta = new Luta("luta", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			assertEquals("Preco Invalido", e.getMessage());
		}

	}

	@Test
	public void testRegistraJogada() throws Exception {
		Assert.assertEquals(10, luta.registraJogada(10000, true));
		Assert.assertEquals(10000, luta.getMaiorScore());
		Assert.assertEquals(1, luta.getVezesZeradas());
		Assert.assertEquals(1, luta.getQuantidadeJogada());

		Assert.assertEquals(0, luta.registraJogada(9999, true));
		Assert.assertEquals(10000, luta.getMaiorScore());
		Assert.assertEquals(2, luta.getVezesZeradas());
		Assert.assertEquals(2, luta.getQuantidadeJogada());

		Assert.assertEquals(0, luta.registraJogada(1000, false));
		Assert.assertEquals(10000, luta.getMaiorScore());
		Assert.assertEquals(2, luta.getVezesZeradas());
		Assert.assertEquals(3, luta.getQuantidadeJogada());

		Assert.assertEquals(100, luta.registraJogada(100000, false));
		Assert.assertEquals(100000, luta.getMaiorScore());
		Assert.assertEquals(2, luta.getVezesZeradas());
		Assert.assertEquals(4, luta.getQuantidadeJogada());

	}

	@Test
	public void testJogadaInvalida() throws Exception {
		try {
			luta.registraJogada(-1, true);
		} catch (PontuacaoInvalidaException e) {
			assertEquals("pontuacao invalida", e.getMessage());
		}

		try {
			luta.registraJogada(100001, true);
		} catch (PontuacaoInvalidaException e) {
			assertEquals("pontuacao invalida", e.getMessage());
		}

	}

	@Test
	public void TestToString() throws Exception {
		Assert.assertEquals(10, luta.registraJogada(10000, true));
		Assert.assertEquals(10000, luta.getMaiorScore());
		Assert.assertEquals(1, luta.getVezesZeradas());
		Assert.assertEquals(1, luta.getQuantidadeJogada());

		Assert.assertEquals("luta - Luta:" + FIM_DE_LINHA + "==> Jogou " + luta.getQuantidadeJogada() + " vez(es)"
				+ FIM_DE_LINHA + "==> Zerou " + luta.getVezesZeradas() + " vez(es)" + FIM_DE_LINHA + "==> Maior Score: "
				+ luta.getMaiorScore() + FIM_DE_LINHA, luta.toString());
	}
}
