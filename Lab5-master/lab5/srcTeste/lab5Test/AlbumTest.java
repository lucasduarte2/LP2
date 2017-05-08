/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package lab5Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import s2pfy.Album;
import s2pfy.Musica;

public class AlbumTest {

	public static final String LINHA = System.lineSeparator();
	private Album DayOff;

	@Before
	public void setUp() throws Exception {
		DayOff = new Album("Marcia Fellipe", "Day Off", 2016);
	}

	@Test
	public void testToString() {
		Assert.assertEquals("Artista - Marcia Fellipe" + LINHA + "Album - Day Off" + LINHA + "Ano Lancamento 2016",
				DayOff.toString());
	}

	@Test
	public void testConstrutorWithException() {

		// Test Artista Vazio/Null
		try {
			Album album = new Album("  ", "Day Off", 2016);
			Assert.fail("Lancamento de Exception com Artista vazio");

		} catch (Exception e) {
			Assert.assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());
		}

		try {
			Album album1 = new Album(null, "Day Off", 2016);
			Assert.fail("Lancamento de Exception com Artista null");

		} catch (Exception e) {
			Assert.assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());

		}

		// Test Titulo Vazio/Null
		try {
			Album album = new Album("Marcia Fellipe", "", 2016);
			Assert.fail("Lancamento de Exception com Titulo Vazio");

		} catch (Exception e) {
			Assert.assertEquals("Titulo do album nao pode ser nulo ou vazio.", e.getMessage());

		}
		try {
			Album album2 = new Album("Marcia Fellipe", null, 2016);
			Assert.fail("Lancamento de Exception com Titulo null");

		} catch (Exception e) {
			Assert.assertEquals("Titulo do album nao pode ser nulo ou vazio.", e.getMessage());

		}

		// Test Ano de Lancamento Inferior ao esperado/Nulo

		try {
			Album album = new Album("Marcia Fellipe", "Day Off", 1899);
			Assert.fail("Exception com Ano de Lancamento Inferior ao esperado");

		} catch (Exception e) {
			Assert.assertEquals("Ano de lancamento do album nao pode ser inferior a 1900.", e.getMessage());

		}
		try {
			Album album1 = new Album("Marcia Fellipe", "Day Off", 0);
			Assert.fail("Exception com ano de Lancamento nulo");

		} catch (Exception e) {
			Assert.assertEquals("Ano de lancamento do album nao pode ser inferior a 1900.", e.getMessage());
		}
	}

	@Test
	public void testAddFaixa() throws Exception {
		Musica taVendo = new Musica("ta vendo", 3, "Forro");
		Musica maisQueIsso = new Musica("Mais que Isso", 3, "Forro");
		Musica elaNaoSabe = new Musica("Ela nao Sabe", 4, "Forro");
		Musica seVcQueSaber = new Musica("Se Voce Quer Saber", 2, "Forro");

		Assert.assertTrue(DayOff.adicionaMusica(taVendo));
		// adicionar musicas tidas como iguais.
		Assert.assertTrue(DayOff.adicionaMusica(maisQueIsso));
		Assert.assertTrue(DayOff.adicionaMusica(elaNaoSabe));

		Assert.assertTrue(DayOff.contemMusica("ta vendo"));
		Assert.assertTrue(DayOff.contemMusica("Ela nao Sabe"));
		Assert.assertFalse(DayOff.contemMusica("Se Voce Quer Saber"));

		// casos invalidos de adicao
		Assert.assertFalse(DayOff.adicionaMusica(null));
	}

	@Test
	public void testRemoveFaixa() throws Exception {
		Musica taVendo = new Musica("ta vendo", 3, "Forro");
		DayOff.adicionaMusica(taVendo);

		Assert.assertTrue(DayOff.contemMusica("ta vendo"));

		DayOff.removeMusica(1);
		Assert.assertFalse(DayOff.contemMusica("ta vendo"));

	}

	@Test
	public void testNumeroDeFaixas() throws Exception {
		Musica taVendo = new Musica("ta vendo", 3, "Forro");
		DayOff.adicionaMusica(taVendo);
		Assert.assertEquals(1, DayOff.quantidaDeFaixas());
	}

	@Test
	public void testGetMusica() throws Exception {
		Musica maisQueIsso = new Musica("Mais que Isso", 3, "Forro");
		DayOff.adicionaMusica(maisQueIsso);
		Assert.assertEquals(maisQueIsso, DayOff.getMusica("Mais que Isso"));
	}

	@Test
	public void testDuracaoTotal() throws Exception {
		Musica taVendo = new Musica("ta vendo", 3, "Forro");
		Musica maisQueIsso = new Musica("Mais que Isso", 3, "Forro");
		DayOff.adicionaMusica(taVendo);
		DayOff.adicionaMusica(maisQueIsso);

		Assert.assertEquals(6, DayOff.getDuracaoTotal());
	}

	@Test
	public void testEquals() throws Exception {
		Musica taVendo = new Musica("ta vendo", 3, "Forro");
		DayOff.adicionaMusica(taVendo);

		Album dayOff = new Album("Marcia Fellipe", "Day Off", 2016);
		Assert.assertTrue(DayOff.equals(dayOff));
	}

	@Test
	public void testNotEquals() throws Exception {
		Musica taVendo = new Musica("ta vendo", 3, "Forro");
		DayOff.adicionaMusica(taVendo);

		Album mfAoVivo = new Album("Marcia fellipe", "Marcia fellipe Ao Vivo", 2016);
		mfAoVivo.adicionaMusica(taVendo);

		Assert.assertFalse(DayOff.equals(mfAoVivo));
	}
}
