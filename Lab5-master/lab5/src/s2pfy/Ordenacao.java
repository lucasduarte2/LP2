/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package s2pfy;

import java.util.Comparator;

public class Ordenacao {

	public static Comparator<Album> albumPorAno = new Comparator<Album>() {

		@Override
		public int compare(Album o1, Album o2) {
			return o1.getAnoDeLancamento() - o2.getAnoDeLancamento();
		}
	};

	public static Comparator<Album> duracao = new Comparator<Album>() {

		@Override
		public int compare(Album o1, Album o2) {
			return o1.getDuracaoTotal() - o2.getDuracaoTotal();
		}
	};

	public static Comparator<Album> quantidadeMusica = new Comparator<Album>() {

		@Override
		public int compare(Album o1, Album o2) {
			return o1.quantidaDeFaixas() - o2.quantidaDeFaixas();
		}
	};

	public static Comparator<Album> artista = new Comparator<Album>() {

		@Override
		public int compare(Album o1, Album o2) {
			return o1.getArtista().compareTo(o2.getArtista());
		}
	};

}