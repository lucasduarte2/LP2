/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package s2pfy;

import java.util.ArrayList;

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
public class Album {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	private String artista;
	private String titulo;
	private int anoDeLancamento;
	private ArrayList<Musica> album;
	
	/**
	 * O construtor Album com tres argumento inicializa cada variável de instância
	 *como String para artista e para titulo, e integer para ano de lancamento e 
	 *um arrayList para guarda musicas no album.
	 *Isso assegura que objetos Album iniciem em um estado
	 *consistente
	 * @param artista
	 * @param titulo
	 * @param anoDeLancamento 
	 * @throws AnoInvalidoException em caso de um ano invalido.
	 * @throws TituloInvalidoException em caso de um titulo invalido.
	 * @throws ArtistaInvalidoException em caso de um artista invalido.
	 */
	public Album(String artista, String titulo, int anoDeLancamento)
			throws AnoInvalidoException, TituloInvalidoException, ArtistaInvalidoException {

		if (artista == null || artista.trim().isEmpty()) {
			throw new ArtistaInvalidoException();
		}
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new TituloInvalidoException("Titulo do album");
		}
		if (anoDeLancamento < 1900) {
			throw new AnoInvalidoException();
		}
		this.artista = artista;
		this.titulo = titulo;
		this.anoDeLancamento = anoDeLancamento;
		this.album = new ArrayList<Musica>();
	}
	/**
	 * metodo para verificar se o nome da musica e valido.
	 * @param musica
	 * @throws MusicaInvalidaException em caso de musica invalida.
	 */
	private void ValidaMusica(String musica) throws MusicaInvalidaException {
		if (musica == null || musica.trim().isEmpty()) {
			throw new MusicaInvalidaException();
		}
	}
	/**
	 * metodo para adicionar o objeto musica no arrayList de album
	 * @param musica
	 * @return boolean
	 * @throws MusicaInvalidaException em caso de uma musica invalida.
	 */
	public boolean adicionaMusica(Musica musica) throws MusicaInvalidaException {
		if (musica == null) {
			return false;
		}
		return this.album.add(musica);
	}
	/**
	 * metodo para verificar se contem uma musica no arrayList de album
	 * @param musica
	 * @return boolean
	 * @throws MusicaInvalidaException em caso de uma musica invalida.
	 */
	public boolean contemMusica(String musica) throws MusicaInvalidaException {
		ValidaMusica(musica);
		for (Musica music : album) {
			if (music.getTituloMusica().equals(musica)) {
				return true;
			}
		}
		return false;

	}
	/**
	 * metodo para remover uma musica no arayList de album pelo indice.
	 * @param faixa
	 * @throws FaixaInvalidaException em caso de uma faixa invalida.
	 */
	public void removeMusica(int faixa) throws FaixaInvalidaException {
		if (faixa < 1) {
			throw new FaixaInvalidaException();
		}
		album.remove(faixa - 1);
	}
	/**
	 * metodo para ver a quantidade de musicas no arrayList de album.
	 * @return integer.
	 */
	public int quantidaDeFaixas() {
		return album.size();

	}
	/**
	 * metodo para ver a duracao de todas as musicas contida no album
	 * @return integer.
	 */
	public int getDuracaoTotal() {
		int duracao = 0;
		for (Musica musica : album) {
			duracao += musica.getDuracaoEsperada();
		}
		return duracao;
	}
	/**
	 * metodo para retorna um objeto do tipo musica, atravez do seu nome.
	 * @param musica
	 * @return Musica
	 * @throws MusicaInvalidaException em caso de musica invalida
	 */
	public Musica getMusica(String musica) throws MusicaInvalidaException {
		ValidaMusica(musica);
		for (Musica music : album) {
			if (music.getTituloMusica().equals(musica)) {
				return music;
			}
		}
		return null;
	}
	/**
	 * metodo para retorna um objeto do tipo musica atravez de um indice.
	 * @param faixa
	 * @return Musica
	 * @throws FaixaInvalidaException em caso de uma faixa invalida
	 */
	public Musica getMusica(int faixa) throws FaixaInvalidaException {
		if (faixa < 1) {
			throw new FaixaInvalidaException();
		}

		return album.get(faixa - 1);

	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) throws AnoInvalidoException {
		if (anoDeLancamento < 1900) {
			throw new AnoInvalidoException();
		}
		this.anoDeLancamento = anoDeLancamento;
	}

	public ArrayList<Musica> getAlbum() {
		return album;
	}

	public void setAlbum(ArrayList<Musica> album) {
		this.album = album;
	}

	@Override
	public String toString() {

		return "Artista - " + this.artista + FIM_DE_LINHA + "Album - " + this.titulo + FIM_DE_LINHA + "Ano Lancamento "
				+ this.anoDeLancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Album other = (Album) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
