/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package lab5Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import s2pfy.Album;
import s2pfy.Musica;
import s2pfy.Musiteca;

public class MusitecaTest {

	private Musiteca musiteca;
	private Album dayOff;
	private Musica maisQueIsso;
	private Musica seVcQueSaber;
	private Musica elaNaoSabe;
	private Musica taVendo;
	private Musica coracaoVagabundo;

	@Before
	public void setUp() throws Exception {
		musiteca = new Musiteca();
		this.dayOff = new Album("Marcia Fellipe", "Day Off", 2016);
		this.maisQueIsso = new Musica("Mais que Isso", 3, "Forro");
		this.seVcQueSaber = new Musica("Se Voce Quer Saber", 2, "Forro");
		this.elaNaoSabe = new Musica("Ela nao Sabe", 4, "Forro");
		this.taVendo = new Musica("ta vendo", 3, "Forro");
		this.coracaoVagabundo = new Musica("Coracao Vagabundo", 3, "Forro");

	}

	@Test
	public void testCriaAlbum() throws Exception {
		assertTrue(dayOff.adicionaMusica(taVendo));
		assertTrue(dayOff.adicionaMusica(maisQueIsso));
		// nao pode adicionar albuns repetidos.
		assertTrue(musiteca.addAlbum(dayOff));
		assertFalse(musiteca.addAlbum(dayOff));
	}

	@Test
	public void removeAlbum() throws Exception {
		Album emCasa = new Album("Wesley safadao", "WS em casa", 2016);
		Musica camarote = new Musica("Camarote", 4, "Forro");

		assertTrue(dayOff.adicionaMusica(taVendo));
		assertTrue(dayOff.adicionaMusica(maisQueIsso));
		assertTrue(emCasa.adicionaMusica(camarote));

		assertTrue(musiteca.addAlbum(emCasa));
		assertTrue(musiteca.addAlbum(dayOff));

		assertTrue(musiteca.removeAlbum(emCasa));
		assertEquals(1, musiteca.getQtdMeusAlbuns());

	}

	@Test
	public void testFavoritaAlbum() throws Exception {

		// adicionar na musiteca
		assertTrue(musiteca.addAlbum(dayOff));
		assertTrue(musiteca.contemAlbum(dayOff));

		// adicionar aos favoritos.
		assertTrue(musiteca.addAosFavoritos(dayOff));
		assertFalse(musiteca.addAosFavoritos(dayOff));

		assertEquals(1, musiteca.getQtdFavoritos());
	}

	@Test
	public void testRenoverFavorito() throws Exception {
		dayOff.adicionaMusica(coracaoVagabundo);
		dayOff.adicionaMusica(taVendo);

		assertTrue(musiteca.addAlbum(dayOff));
		assertTrue(musiteca.addAosFavoritos(dayOff));

		Musica camarote = new Musica("Camarote", 4, "Forro");
		Album emCasa = new Album("Wesley safadao", "WS em casa", 2016);

		assertTrue(emCasa.adicionaMusica(camarote));
		assertTrue(musiteca.addAlbum(emCasa));
		assertTrue(musiteca.addAosFavoritos(emCasa));
		assertEquals(2, musiteca.getQtdFavoritos());

		assertTrue(musiteca.removeFavoritos(emCasa));
		assertEquals(1, musiteca.getQtdFavoritos());

	}

	@Test
	public void testCriaEAddPlaylist() throws Exception {
		// cria uma playlist vazia, mas nao pode
		// criar mais de uma playlist com
		// o mesmo titulo.
		assertTrue(musiteca.criaPlaylist("Forro"));
		assertFalse(musiteca.criaPlaylist("Forro"));
		assertTrue(musiteca.contemPlaylist("Forro"));

	}

	@Test
	public void pesquisaMusicaPlayList() throws Exception {
		dayOff.adicionaMusica(coracaoVagabundo);

		assertTrue(musiteca.addAlbum(dayOff));
		assertTrue(musiteca.criaPlaylist("Forro"));
		// adiciona na playlist de nome Forro:
		// a faixa 1 do album 'Day Off';
		assertTrue(musiteca.addNaPlaylist("Forro", "Day Off", 1));

		assertEquals(1, musiteca.getPlaylistSize("Forro"));
		// verifica se a playlist Forro tem uma musica com esse nome.
		assertTrue(musiteca.contemNaPlaylist("Forro", "Coracao Vagabundo"));
	}

	@Test
	public void removePlayList() throws Exception {

		assertTrue(dayOff.adicionaMusica(taVendo));
		assertTrue(dayOff.adicionaMusica(maisQueIsso));
		assertTrue(dayOff.adicionaMusica(elaNaoSabe));
		assertTrue(dayOff.adicionaMusica(seVcQueSaber));

		Musica camarote = new Musica("Camarote", 4, "Forro");
		Album emCasa = new Album("Wesley safadao", "WS em casa", 2016);
		assertTrue(emCasa.adicionaMusica(camarote));

		assertTrue(musiteca.addAlbum(dayOff));
		assertTrue(musiteca.addAlbum(emCasa));

		assertTrue(musiteca.criaPlaylist("Forro"));
		assertTrue(musiteca.criaPlaylist("WS"));

		// adiciona na playlist de nome Forro:
		// a faixa 1 do album 'Day Off';
		assertTrue(musiteca.addNaPlaylist("Forro", "Day Off", 1));
		assertTrue(musiteca.addNaPlaylist("Forro", "Day Off", 2));
		assertTrue(musiteca.addNaPlaylist("Forro", "Day Off", 3));
		assertTrue(musiteca.addNaPlaylist("WS", "Day Off", 1));

		assertEquals(3, musiteca.getPlaylistSize("Forro"));
		assertEquals(1, musiteca.getPlaylistSize("WS"));
		assertEquals(2, musiteca.getPlayList());

		assertTrue(musiteca.removerMusicaPlayList("Forro", 1));
		assertEquals(2, musiteca.getPlaylistSize("Forro"));

		assertTrue(musiteca.removerPlayList("WS"));

		assertEquals(1, musiteca.getPlayList());
	}

	@Test
	public void testExeptionCases() throws Exception {

		try {
			musiteca.addAlbum(null);
		} catch (Exception e) {
			assertEquals("Album nao pode ser vazio ou nulo", e.getMessage());
		}
	}

	@Test
	public void testToSring() throws Exception {
		dayOff.adicionaMusica(taVendo);
		dayOff.adicionaMusica(maisQueIsso);

		// nao pode adicionar albuns repetidos.
		assertTrue(musiteca.addAlbum(dayOff));
		assertFalse(musiteca.addAlbum(dayOff));
		Assert.assertEquals("Musiteca:" + Album.FIM_DE_LINHA + Album.FIM_DE_LINHA + "=== Meus Albuns ==="
				+ Album.FIM_DE_LINHA + Album.FIM_DE_LINHA + "Artista - Marcia Fellipe" + Album.FIM_DE_LINHA
				+ "Album - Day Off" + Album.FIM_DE_LINHA + "Ano Lancamento 2016" + Album.FIM_DE_LINHA
				+ Album.FIM_DE_LINHA + "=== Albuns Favoritos ===" + Album.FIM_DE_LINHA + Album.FIM_DE_LINHA,
				musiteca.toString());
	}

	@Test
	public void testOrdenaPorArtista() throws Exception {

		Album poolParty = new Album("Avioes do Forro", "Pool Party do Avioes", 2015);
		Musica bancaDeFlores = new Musica("Banca de Flores", 3, "Forro");

		assertTrue(dayOff.adicionaMusica(coracaoVagabundo));
		assertTrue(dayOff.adicionaMusica(taVendo));

		Musica camarote = new Musica("Camarote", 4, "Forro");
		Album emCasa = new Album("Wesley Safadao", "WS em Casa", 2016);

		assertTrue(emCasa.adicionaMusica(camarote));
		assertTrue(musiteca.addAlbum(emCasa));
		assertTrue(musiteca.addAlbum(poolParty));
		assertTrue(musiteca.addAlbum(dayOff));

		ArrayList<Album> albumOrdenado = new ArrayList<>();
		albumOrdenado.add(0, poolParty);
		albumOrdenado.add(1, dayOff);
		albumOrdenado.add(2, emCasa);
		assertEquals(albumOrdenado, musiteca.sortedAlbuns("artista"));

	}

	@Test
	public void testOrdenaPorQtdMusica() throws Exception {
		Album poolParty = new Album("Avioes do Forro", "Pool Party do Avioes", 2015);
		Musica bancaDeFlores = new Musica("Banca de Flores", 3, "Forro");
		Musica fiqueiSabendo = new Musica("Fiquei Sabendo", 4, "Forro");
		assertTrue(poolParty.adicionaMusica(bancaDeFlores));
		assertTrue(poolParty.adicionaMusica(fiqueiSabendo));

		assertTrue(dayOff.adicionaMusica(coracaoVagabundo));
		assertTrue(dayOff.adicionaMusica(taVendo));
		assertTrue(dayOff.adicionaMusica(maisQueIsso));

		Musica camarote = new Musica("Camarote", 4, "Forro");
		Album emCasa = new Album("Wesley Safadao", "WS em Casa", 2016);

		assertTrue(emCasa.adicionaMusica(camarote));
		assertTrue(musiteca.addAlbum(emCasa));
		assertTrue(musiteca.addAlbum(poolParty));
		assertTrue(musiteca.addAlbum(dayOff));

		ArrayList<Album> albumOrdenado = new ArrayList<>();
		albumOrdenado.add(0, emCasa);
		albumOrdenado.add(1, poolParty);
		albumOrdenado.add(2, dayOff);
		assertEquals(albumOrdenado, musiteca.sortedAlbuns("quantidade"));

	}

	@Test
	public void testOrdenaPorDuracao() throws Exception {
		Album poolParty = new Album("Avioes do Forro", "Pool Party do Avioes", 2015);
		Musica bancaDeFlores = new Musica("Banca de Flores", 3, "Forro");
		Musica fiqueiSabendo = new Musica("Fiquei Sabendo", 4, "Forro");
		assertTrue(poolParty.adicionaMusica(bancaDeFlores));
		assertTrue(poolParty.adicionaMusica(fiqueiSabendo));

		assertTrue(dayOff.adicionaMusica(coracaoVagabundo));
		assertTrue(dayOff.adicionaMusica(taVendo));
		assertTrue(dayOff.adicionaMusica(maisQueIsso));

		Musica camarote = new Musica("Camarote", 4, "Forro");
		Album emCasa = new Album("Wesley Safadao", "WS em Casa", 2016);

		assertTrue(emCasa.adicionaMusica(camarote));
		assertTrue(musiteca.addAlbum(emCasa));
		assertTrue(musiteca.addAlbum(poolParty));
		assertTrue(musiteca.addAlbum(dayOff));

		ArrayList<Album> albumOrdenado = new ArrayList<>();
		albumOrdenado.add(0, emCasa);
		albumOrdenado.add(1, poolParty);
		albumOrdenado.add(2, dayOff);
		assertEquals(albumOrdenado, musiteca.sortedAlbuns("duracao"));

	}

	@Test
	public void testOrdenaPorAno() throws Exception {
		Album poolParty = new Album("Avioes do Forro", "Pool Party do Avioes", 2015);
		Musica bancaDeFlores = new Musica("Banca de Flores", 3, "Forro");
		Musica fiqueiSabendo = new Musica("Fiquei Sabendo", 4, "Forro");
		assertTrue(poolParty.adicionaMusica(bancaDeFlores));
		assertTrue(poolParty.adicionaMusica(fiqueiSabendo));

		assertTrue(dayOff.adicionaMusica(coracaoVagabundo));
		assertTrue(dayOff.adicionaMusica(taVendo));
		assertTrue(dayOff.adicionaMusica(maisQueIsso));

		Musica camarote = new Musica("Camarote", 4, "Forro");
		Album emCasa = new Album("Wesley Safadao", "WS em Casa", 2017);

		assertTrue(emCasa.adicionaMusica(camarote));
		assertTrue(musiteca.addAlbum(emCasa));
		assertTrue(musiteca.addAlbum(poolParty));
		assertTrue(musiteca.addAlbum(dayOff));

		ArrayList<Album> albumOrdenado = new ArrayList<>();
		albumOrdenado.add(0, poolParty);
		albumOrdenado.add(1, dayOff);
		albumOrdenado.add(2, emCasa);
		assertEquals(albumOrdenado, musiteca.sortedAlbuns("ano"));

	}

}
