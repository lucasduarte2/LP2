package TestJogo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Jogo.Jogo;
import Jogo.Luta;
import Jogo.Plataforma;
import excecoes.NomeInvalidoException;
import excecoes.PontuacaoInvalidaException;
import excecoes.PrecoInvalidoException;

public class TestPlataforma {

	private Jogo plataforma;
	public static final String FIM_DE_LINHA = System.lineSeparator();

	@Before
	public void setUp() throws Exception {
		this.plataforma = new Plataforma("plataforma", 100);
	}

	@Test
	public void testCriaJogo() {
		try {
			Jogo luta = new Plataforma("plataforma", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCriaJogoException() {
		try {
			Jogo luta = new Plataforma("plataforma", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			assertEquals("Nome do jogo invalido", e.getMessage());
		}

		try {
			Jogo luta = new Plataforma("plataforma", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			assertEquals("Nome do jogo invalido", e.getMessage());
		}

		try {
			Jogo luta = new Plataforma("plataforma", 100);
		} catch (NomeInvalidoException | PrecoInvalidoException e) {
			assertEquals("Preco Invalido", e.getMessage());
		}

	}

	@Test
	public void testRegistraJogada() throws Exception {
		Assert.assertEquals(20, plataforma.registraJogada(10000, true));
		Assert.assertEquals(10000, plataforma.getMaiorScore());
		Assert.assertEquals(1, plataforma.getVezesZeradas());
		Assert.assertEquals(1, plataforma.getQuantidadeJogada());

		Assert.assertEquals(20, plataforma.registraJogada(9999, true));
		Assert.assertEquals(10000, plataforma.getMaiorScore());
		Assert.assertEquals(2, plataforma.getVezesZeradas());
		Assert.assertEquals(2, plataforma.getQuantidadeJogada());

		Assert.assertEquals(0, plataforma.registraJogada(1000, false));
		Assert.assertEquals(10000, plataforma.getMaiorScore());
		Assert.assertEquals(2, plataforma.getVezesZeradas());
		Assert.assertEquals(3, plataforma.getQuantidadeJogada());

		Assert.assertEquals(0, plataforma.registraJogada(100000, false));
		Assert.assertEquals(100000, plataforma.getMaiorScore());
		Assert.assertEquals(2, plataforma.getVezesZeradas());
		Assert.assertEquals(4, plataforma.getQuantidadeJogada());

	}

	@Test
	public void testJogadaInvalida() throws Exception {
		try {
			plataforma.registraJogada(-1, true);
		} catch (PontuacaoInvalidaException e) {
			assertEquals("pontuacao invalida", e.getMessage());
		}

		try {
			plataforma.registraJogada(100001, true);
		} catch (PontuacaoInvalidaException e) {
			assertEquals("pontuacao invalida", e.getMessage());
		}

	}

	@Test
	public void TestToString() throws Exception {
		Assert.assertEquals(20, plataforma.registraJogada(10000, true));
		Assert.assertEquals(10000, plataforma.getMaiorScore());
		Assert.assertEquals(1, plataforma.getVezesZeradas());
		Assert.assertEquals(1, plataforma.getQuantidadeJogada());

		Assert.assertEquals("plataforma - Plataforma:" + FIM_DE_LINHA + "==> Jogou " + plataforma.getQuantidadeJogada()
				+ " vez(es)" + FIM_DE_LINHA + "==> Zerou " + plataforma.getVezesZeradas() + " vez(es)" + FIM_DE_LINHA
				+ "==> Maior Score: " + plataforma.getMaiorScore() + FIM_DE_LINHA, plataforma.toString());
	}

}
