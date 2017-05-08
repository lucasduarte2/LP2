/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package s2pfy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import excecoes.AlbumInvalidoException;
import excecoes.AnoInvalidoException;
import excecoes.ArtistaInvalidoException;
import excecoes.FaixaInvalidaException;
import excecoes.MusicaInvalidaException;
import excecoes.TituloInvalidoException;

/**
 * 
 * @author Lucas Venancio Duarte
 *
 */
public class Musiteca {

	private HashSet<Album> meusAlbuns;
	private HashSet<Album> albunsFavoritos;
	private HashMap<String, PlayList> playList;
	private Ordenacao ordenacao;

	/**
	 * O construtor Musiteca sem argumento inicializa cada variável de
	 * instância.
	 */
	public Musiteca() {

		this.meusAlbuns = new HashSet<Album>();
		this.albunsFavoritos = new HashSet<Album>();
		this.playList = new HashMap<>();
		this.ordenacao = new Ordenacao();

	}

	/**
	 * O metodo addAlbum adiciona objeto do tipo Album no HashSet de meus
	 * albuns.
	 * 
	 * @param album
	 * @return boolean
	 * @throws AlbumInvalidoException
	 *             em caso de album invalido
	 */
	public boolean addAlbum(Album album) throws AlbumInvalidoException {
		Validacao(album);
		return this.meusAlbuns.add(album);
	}

	/**
	 * O metodo renoveAlbum remove objeto do tipo Album no HashSet de meus
	 * albuns.
	 * 
	 * @param album
	 * @return boolean
	 * @throws AlbumInvalidoException
	 *             em caso de album invalido
	 */
	public boolean removeAlbum(Album album) throws AlbumInvalidoException {
		Validacao(album);
		return this.meusAlbuns.remove(album);

	}

	/**
	 * O metodo contemAlbum verifica se contem o objeto do tipo Album no HashSet
	 * de meus albuns.
	 * 
	 * @param album
	 * @return boolean
	 * @throws AlbumInvalidoException
	 *             em caso de album invalido
	 */
	public boolean contemAlbum(Album album) throws AlbumInvalidoException {
		Validacao(album);
		if (!meusAlbuns.contains(album)) {
			return false;
		}
		return meusAlbuns.contains(album);
	}

	/**
	 * O metodo getAlbum verifica se contem o nome do Album no HashSet de meus
	 * albuns, e retorna o Objeto Album.
	 * 
	 * @param nomeAlbum
	 * @return Album
	 * @throws AlbumInvalidoException
	 *             em caso de album invalido
	 */
	private Album getAlbum(String nomeAlbum) throws AlbumInvalidoException {
		for (Album album : meusAlbuns) {
			if (album.getTitulo().equals(nomeAlbum)) {
				return album;
			}
		}
		throw new AlbumInvalidoException("Album nao pertence ao Perfil especificado");
	}

	/**
	 * O metodo getQtdAlbuns revifica a quantidade de albuns no HashSet de meus
	 * albuns.
	 * 
	 * @return integer
	 */
	public int getQtdMeusAlbuns() {
		return this.meusAlbuns.size();
	}

	/**
	 * O metodo albumDoArtista procura e retorna todos os albuns do artista do
	 * HashSet de meus albuns.
	 * 
	 * @param artista
	 * @return HashSet<Album>
	 * @throws ArtistaInvalidoException
	 *             em caso de artista invalido
	 */
	public HashSet<Album> albumDoArtista(String artista) throws ArtistaInvalidoException {
		if (artista == null || artista.trim().isEmpty()) {
			throw new ArtistaInvalidoException();
		}
		HashSet<Album> albunsDoArtista = new HashSet<Album>();
		for (Album album : meusAlbuns) {
			if (album.getArtista().equals(artista)) {
				albunsDoArtista.add(album);
			}
		}
		return albunsDoArtista;

	}

	/**
	 * O metodo albumPorTitulo procura e retorna todos os albuns por titulo do
	 * HashSet de meus albuns.
	 * 
	 * @param titulo
	 * @return HashSet<Album>
	 * @throws TituloInvalidoException
	 *             em caso de titulo invalido
	 */
	public HashSet<Album> albumPorTitulo(String titulo) throws TituloInvalidoException {
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new TituloInvalidoException("Titulo do album");
		}
		HashSet<Album> albunsPorTitulo = new HashSet<Album>();
		for (Album album : meusAlbuns) {
			if (album.getTitulo().equals(titulo)) {
				albunsPorTitulo.add(album);
			}
		}
		return albunsPorTitulo;

	}

	/**
	 * O metodo albumPorAnoLancamento procura e retorna todos os albuns por ano
	 * do HashSet de meus albuns.
	 * 
	 * @param anoDeLancamento
	 * @return HashSet<Album>
	 * @throws AnoInvalidoException
	 *             em caso de ano invalido
	 */
	public HashSet<Album> albumPorAnoLancamento(int anoDeLancamento) throws AnoInvalidoException {
		if (anoDeLancamento < 1900) {
			throw new AnoInvalidoException();
		}
		HashSet<Album> albunsPorAnoDeLancamento = new HashSet<Album>();
		for (Album album : meusAlbuns) {
			if (album.getAnoDeLancamento() == anoDeLancamento) {
				albunsPorAnoDeLancamento.add(album);
			}
		}
		return albunsPorAnoDeLancamento;

	}

	/**
	 * O metodo addAosFavoritos adiciona Objetos do tipo AlBum no HashSet de
	 * albunsFavoritos.
	 * 
	 * @param album
	 * @return boolean
	 * @throws AlbumInvalidoException
	 *             em caso de album invalido
	 */
	public boolean addAosFavoritos(Album album) throws AlbumInvalidoException {
		Validacao(album);
		contemAlbum(album);
		return this.albunsFavoritos.add(album);

	}

	/**
	 * O metodo remove Favoritos remove Objetos do tipo AlBum no HashSet de
	 * albuns Favoritos.
	 * 
	 * @param album
	 * @return boolean
	 * @throws AlbumInvalidoException
	 *             em caso de album invalido
	 */
	public boolean removeFavoritos(Album album) throws AlbumInvalidoException {
		Validacao(album);
		return this.albunsFavoritos.remove(album);

	}

	/**
	 * O metodo getQtdFavoritos revifica a quantidade de albuns favoritos no
	 * HashSet de albuns Favoritos.
	 * 
	 * @return integer
	 */
	public int getQtdFavoritos() {
		return this.albunsFavoritos.size();
	}

	/**
	 * O metodo criaPlaylist cria uma nova playList com uma chave / nome e um
	 * arrayList do tipo PlayList.
	 * 
	 * @param tituloPlayList
	 * @return boolean
	 * @throws TituloInvalidoException
	 *             em caso de titulo invalido
	 */
	public boolean criaPlaylist(String tituloPlayList) throws TituloInvalidoException {
		if (playList.containsKey(tituloPlayList) || tituloPlayList.trim().isEmpty()) {
			return false;
		}
		playList.put(tituloPlayList, new PlayList(tituloPlayList));
		return true;

	}

	/**
	 * O metodo contemPlaylist verifica se contem uma playList no mapa de
	 * Playlist.
	 * 
	 * @param tituloPlayList
	 * @return boolean
	 * @throws TituloInvalidoException
	 *             em caso de titulo invalido
	 */
	public boolean contemPlaylist(String tituloPlayList) throws TituloInvalidoException {
		Validacao(tituloPlayList);
		return playList.containsKey(tituloPlayList);

	}

	/**
	 * O metodo getPlaylistSize verifica o tamanho de uma playList.
	 * 
	 * @param tituloPlayList
	 * @return integer
	 * @throws TituloInvalidoException
	 *             em caso de titulo invalido
	 */
	public int getPlaylistSize(String tituloPlayList) throws TituloInvalidoException {
		Validacao(tituloPlayList);
		return playList.get(tituloPlayList).quantidaDeFaixas();

	}

	/**
	 * O metodo contemNaPlaylist verifica se contem no mapa da playlist uma
	 * musica na playlist passada como parametro.
	 * 
	 * @param tituloPlayList
	 * @param musica
	 * @return boolean
	 * @throws MusicaInvalidaException
	 *             em caso de musica invalida
	 * @throws TituloInvalidoException
	 *             em caso de titulo invalido
	 */
	public boolean contemNaPlaylist(String tituloPlayList, String musica)
			throws MusicaInvalidaException, TituloInvalidoException {
		Validacao(tituloPlayList);
		return this.playList.get(tituloPlayList).contemMusica(musica);

	}

	/**
	 * O metodo addNaPlaylist adiciona uma faixa de um album na playlist.
	 * 
	 * @param tituloPlayList
	 * @param nomeAlbum
	 * @param faixa
	 * @return boolean
	 * @throws TituloInvalidoException
	 *             em caso de titulo invalido
	 * @throws FaixaInvalidaException
	 *             em caso de faixa invalida
	 * @throws AlbumInvalidoException
	 *             em caso de album invalido
	 * @throws MusicaInvalidaException
	 *             em caso de musica invalida
	 */
	public boolean addNaPlaylist(String tituloPlayList, String nomeAlbum, int faixa)
			throws TituloInvalidoException, FaixaInvalidaException, AlbumInvalidoException, MusicaInvalidaException {
		Validacao(tituloPlayList);
		Musica musica = getAlbum(nomeAlbum).getMusica(faixa);
		if (!contemPlaylist(tituloPlayList)) {
			criaPlaylist(tituloPlayList);
		}
		return playList.get(tituloPlayList).adicionaMusica(musica);

	}

	/**
	 * O metodo removerPlayList remove toda uma playList.
	 * 
	 * @param tituloPlayList
	 * @return boolean
	 * @throws TituloInvalidoException
	 *             em caso de titulo invalido
	 */
	public boolean removerPlayList(String tituloPlayList) throws TituloInvalidoException {
		Validacao(tituloPlayList);
		playList.remove(tituloPlayList);
		return true;
	}

	/**
	 * O metodo removerMusicaPlayList remove uma faixa de musica de uma
	 * playlist.
	 * 
	 * @param tituloPlayList
	 * @param faixa
	 * @returnboolean
	 * @throws FaixaInvalidaException
	 *             em caso de faixa invalido
	 * @throws TituloInvalidoException
	 *             em caso de titulo invalido
	 */
	public boolean removerMusicaPlayList(String tituloPlayList, int faixa)
			throws FaixaInvalidaException, TituloInvalidoException {
		Validacao(tituloPlayList);
		return playList.get(tituloPlayList).removeMusica(faixa);

	}

	/**
	 * O metodo getPlayList da o tamanho de quantas playList tem.
	 * 
	 * @return integer
	 */
	public int getPlayList() {
		return playList.size();
	}

	/**
	 * O metodo sortedAlbuns ordena os albuns por meeio de diferentes tipos de
	 * ordenacao.
	 * 
	 * @param tipo
	 * @return ArrayList<Album>
	 * @throws Exception
	 */
	public ArrayList<Album> sortedAlbuns(String tipo) throws Exception {
		if (tipo == null || tipo.trim().isEmpty()) {
			throw new Exception("tipo invalido");
		}
		ArrayList<Album> album = new ArrayList<>(meusAlbuns);

		if (tipo.equalsIgnoreCase("ano")) {
			Collections.sort(album, Ordenacao.albumPorAno);
		} else if (tipo.equalsIgnoreCase("duracao")) {
			Collections.sort(album, Ordenacao.duracao);

		} else if (tipo.equalsIgnoreCase("artista")) {
			Collections.sort(album, Ordenacao.artista);

		} else if (tipo.equalsIgnoreCase("quantidade"))

			Collections.sort(album, Ordenacao.quantidadeMusica);

		return album;
	}

	@Override
	public String toString() {
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = "Musiteca:" + FIM_DE_LINHA + FIM_DE_LINHA + "=== Meus Albuns ===" + FIM_DE_LINHA
				+ FIM_DE_LINHA;

		for (Album album : meusAlbuns) {
			toString = toString + album.toString() + FIM_DE_LINHA + FIM_DE_LINHA;
		}

		toString = toString + "=== Albuns Favoritos ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		for (Album album : albunsFavoritos) {
			toString = toString + album.toString() + FIM_DE_LINHA + FIM_DE_LINHA;
		}
		return toString;
	}

	private void Validacao(Album album) throws AlbumInvalidoException {
		if (album == null) {
			throw new AlbumInvalidoException();
		}
	}

	private void Validacao(String tituloPlayList) throws TituloInvalidoException {
		if (tituloPlayList == null || tituloPlayList.trim().isEmpty()) {
			throw new TituloInvalidoException("Titulo da PlayList");
		}
	}

	public HashSet<Album> getMeusAlbuns() {
		return meusAlbuns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albunsFavoritos == null) ? 0 : albunsFavoritos.hashCode());
		result = prime * result + ((meusAlbuns == null) ? 0 : meusAlbuns.hashCode());
		result = prime * result + ((playList == null) ? 0 : playList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musiteca other = (Musiteca) obj;
		if (albunsFavoritos == null) {
			if (other.albunsFavoritos != null)
				return false;
		} else if (!albunsFavoritos.equals(other.albunsFavoritos))
			return false;
		if (meusAlbuns == null) {
			if (other.meusAlbuns != null)
				return false;
		} else if (!meusAlbuns.equals(other.meusAlbuns))
			return false;
		if (playList == null) {
			if (other.playList != null)
				return false;
		} else if (!playList.equals(other.playList))
			return false;
		return true;
	}

}
