/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package s2pfy;

import excecoes.DuracaoInvalidaException;
import excecoes.GeneroInvalidoException;
import excecoes.TituloInvalidoException;
/**
 * 
 * @author Lucas Venancio Duarte
 *
 */
public class Musica {

	private String tituloMusica;
	private int duracaoEsperada;
	private String generoEsperado;

	/**
	 * O construtor Musica com tres argumento inicializa cada variável de instância
	 *como String para titulo e para genero, e integer para duracao.
	 *Isso assegura que objetos Musica iniciem em um estado
	 *consistente
	 * @param tituloMusica
	 * @param duracaoEsperada
	 * @param generoEsperado
	 * @throws TituloInvalidoException em caso de um titulo invalido.
	 * @throws DuracaoInvalidaException em caso de uma duracao invalido.
	 * @throws GeneroInvalidoException em caso de um genero invalido.
	 */
	public Musica(String tituloMusica, int duracaoEsperada, String generoEsperado)
			throws TituloInvalidoException, DuracaoInvalidaException, GeneroInvalidoException {

		if (tituloMusica == null || tituloMusica.trim().isEmpty()) {
			throw new TituloInvalidoException("titulo da musica");
		}
		if (duracaoEsperada <= 0) {
			throw new DuracaoInvalidaException("duracao da musica nao pode ser menor que zero");
		}
		if (generoEsperado == null || generoEsperado.trim().isEmpty()) {
			throw new GeneroInvalidoException();
		}
		this.tituloMusica = tituloMusica;
		this.duracaoEsperada = duracaoEsperada;
		this.generoEsperado = generoEsperado;
	}

	public String getTituloMusica() {
		return tituloMusica;
	}

	public void setTituloMusica(String tituloMusica) {
		this.tituloMusica = tituloMusica;
	}

	public int getDuracaoEsperada() {
		return duracaoEsperada;
	}

	public void setDuracaoEsperada(int duracaoEsperada) {
		this.duracaoEsperada = duracaoEsperada;
	}

	public String getGeneroEsperado() {
		return generoEsperado;
	}

	public void setGeneroEsperado(String generoEsperado) {
		this.generoEsperado = generoEsperado;
	}

	@Override
	public String toString() {
		return "Musica " + this.tituloMusica + Album.FIM_DE_LINHA + "Duracao - " + this.duracaoEsperada
				+ Album.FIM_DE_LINHA + "Genero - " + this.generoEsperado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracaoEsperada;
		result = prime * result + ((tituloMusica == null) ? 0 : tituloMusica.hashCode());
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
		Musica other = (Musica) obj;
		if (duracaoEsperada != other.duracaoEsperada)
			return false;
		if (tituloMusica == null) {
			if (other.tituloMusica != null)
				return false;
		} else if (!tituloMusica.equals(other.tituloMusica))
			return false;
		return true;
	}

}
