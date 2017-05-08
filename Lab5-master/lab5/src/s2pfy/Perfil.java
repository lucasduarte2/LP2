/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package s2pfy;

import java.util.HashSet;

public class Perfil {

	private Musiteca musiteca;
	private String nome;

	public Perfil(String nome) {

		this.nome = nome;
		this.musiteca = new Musiteca();
	}

	public boolean addAlbum(Album album) {
		try {
			return musiteca.addAlbum(album);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return false;
	}

	public boolean removeAlbum(Album album) {
		try {

			return musiteca.removeAlbum(album);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean contemAlbum(Album album) {
		try {
			return musiteca.contemAlbum(album);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public int getQtdMeusAlbuns() {
		try {
			return musiteca.getQtdMeusAlbuns();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public HashSet<Album> albumDoArtista(String artista) {
		try {
			return musiteca.albumDoArtista(artista);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public HashSet<Album> albumPorTitulo(String titulo) {
		try {
			return musiteca.albumPorTitulo(titulo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public HashSet<Album> albumPorAnoLancamento(int ano) {
		try {

			return musiteca.albumPorAnoLancamento(ano);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean addAosFavoritos(Album album) throws Exception {
		try {

			return musiteca.addAosFavoritos(album);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean removeFavoritos(Album album) throws Exception {
		try {
			return musiteca.removeFavoritos(album);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public int getQtdFavoritos() {
		try {
			return musiteca.getQtdFavoritos();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public boolean criaPlaylist(String playlist) {
		try {

			return musiteca.criaPlaylist(playlist);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean contemPlaylist(String nomePlaylist) {
		try {

			return musiteca.contemPlaylist(nomePlaylist);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean addNaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {
		try {

			return musiteca.addNaPlaylist(nomePlaylist, nomeAlbum, faixa);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public int getPlaylistSize(String nomePlaylist) {
		try {
			return musiteca.getPlaylistSize(nomePlaylist);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public boolean contemNaPlaylist(String nomePlaylist, String nomeMusica) {
		try {
			return musiteca.contemNaPlaylist(nomePlaylist, nomeMusica);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
