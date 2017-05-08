/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package lab5Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import s2pfy.Album;
import s2pfy.Musica;

public class MusicaTest {

	private Musica musica;
	private String tituloMusica = "Dependente";
	private int duracaoEsperada = 3;
	private String generoEsperado = "Forro";

	@Before
	public void setup() throws Exception {
		this.musica = new Musica(tituloMusica, duracaoEsperada, generoEsperado);
	}

	@Test
	public void testToString() {
		Assert.assertEquals("Musica " + this.tituloMusica + Album.FIM_DE_LINHA + "Duracao - " + this.duracaoEsperada
				+ Album.FIM_DE_LINHA + "Genero - " + this.generoEsperado, musica.toString());
	}

	@Test
	public void testGetTitulo() {
		Assert.assertEquals(tituloMusica, musica.getTituloMusica());
	}

	@Test
	public void testGetGenero() {
		Assert.assertEquals(generoEsperado, musica.getGeneroEsperado());
	}

	@Test
	public void testGetDuracao() {
		Assert.assertEquals(duracaoEsperada, musica.getDuracaoEsperada());
	}

	@Test(expected = Exception.class)
	public void testTituloVazio() throws Exception {
		musica = new Musica("", 5, generoEsperado);
	}

	@Test(expected = Exception.class)
	public void testTituloNull() throws Exception {
		musica = new Musica(null, 5, generoEsperado);
	}

	@Test(expected = Exception.class)
	public void testGeneroVazio() throws Exception {
		musica = new Musica("coracao teimoso", 4, "");
	}

	@Test(expected = Exception.class)
	public void testGeneroNull() throws Exception {
		musica = new Musica("coracao teimoso", 4, null);
	}

	@Test(expected = Exception.class)
	public void testDuracaoInvalida() throws Exception {
		musica = new Musica("coracao teimoso", -4, "Forro");
	}

	@Test(expected = Exception.class)
	public void testDuracaoZero() throws Exception {
		musica = new Musica("coracao teimoso", 0, "Forro");
	}

}
