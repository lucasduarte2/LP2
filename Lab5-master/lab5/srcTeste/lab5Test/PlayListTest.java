/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package lab5Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excecoes.DuracaoInvalidaException;
import excecoes.FaixaInvalidaException;
import excecoes.GeneroInvalidoException;
import excecoes.MusicaInvalidaException;
import excecoes.TituloInvalidoException;
import s2pfy.Album;
import s2pfy.Musica;
import s2pfy.PlayList;

public class PlayListTest {

	private PlayList playList;
	private Musica maisQueIsso;
	private Musica seVcQueSaber;
	private Musica elaNaoSabe;

	@Before
	public void setUp() throws Exception {
		this.playList = new PlayList("Fenomenal");
		this.maisQueIsso = new Musica("Mais que Isso", 3, "Forro");
		this.seVcQueSaber = new Musica("Se Voce Quer Saber", 2, "Forro");
		this.elaNaoSabe = new Musica("Ela nao Sabe", 4, "Forro");
	}

	@Test
	public void testConstrutorWithException() {

		// Test Artista Vazio/Null
		try {
			PlayList playList = new PlayList("");
			Assert.fail("Lancamento de Exception com Titulo da playList vazio");

		} catch (Exception e) {
			Assert.assertEquals("Titulo da playList nao pode ser nulo ou vazio.", e.getMessage());
		}

		try {
			PlayList playList = new PlayList(null);
			Assert.fail("Lancamento de Exception com Titulo da playList null");

		} catch (Exception e) {
			Assert.assertEquals("Titulo da playList nao pode ser nulo ou vazio.", e.getMessage());

		}
	}

	@Test
	public void testAddMusicaNaPlayList()
			throws TituloInvalidoException, DuracaoInvalidaException, GeneroInvalidoException, MusicaInvalidaException {
		assertTrue(playList.adicionaMusica(maisQueIsso));
		assertTrue(playList.adicionaMusica(seVcQueSaber));
		assertEquals(2, playList.quantidaDeFaixas());
	}

	@Test
	public void testContemMusicaNaPlayList()
			throws TituloInvalidoException, DuracaoInvalidaException, GeneroInvalidoException, MusicaInvalidaException {
		assertTrue(playList.adicionaMusica(maisQueIsso));
		assertTrue(playList.adicionaMusica(seVcQueSaber));
		assertTrue(playList.contemMusica("Mais que Isso"));
		assertEquals(2, playList.quantidaDeFaixas());

		Musica sofroDERessaca = new Musica("Sofro de Ressaca", 3, "Forro");
		assertFalse(playList.contemMusica("Sofro de Ressaca"));
	}

	@Test
	public void testRenoveMusicaNaPlayList() throws FaixaInvalidaException, MusicaInvalidaException {
		assertTrue(playList.adicionaMusica(elaNaoSabe));
		assertTrue(playList.adicionaMusica(maisQueIsso));
		assertTrue(playList.adicionaMusica(seVcQueSaber));
		assertEquals(3, playList.quantidaDeFaixas());

		assertTrue(playList.removeMusica(1));
		assertEquals(2, playList.quantidaDeFaixas());
	}
	
	@Test
	public void testDuracao() throws MusicaInvalidaException {
		assertTrue(playList.adicionaMusica(elaNaoSabe));
		assertTrue(playList.adicionaMusica(maisQueIsso));
		assertTrue(playList.adicionaMusica(seVcQueSaber));
		assertEquals(9, playList.getDuracaoTotal());
	}

}
