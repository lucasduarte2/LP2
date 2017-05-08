/* 116210074 - LUCAS VENANCIO DUARTE: LAB 5 - Turma 3 */
package s2pfy;

import java.util.ArrayList;

import excecoes.FaixaInvalidaException;
import excecoes.MusicaInvalidaException;
import excecoes.TituloInvalidoException;
/**
 * 
 * @author Lucas Venancio Duarte
 *
 */
public class PlayList {
	private ArrayList<Musica> playList;
	private String tituloPlayList;
	/**
	 * O construtor playList com um argumento inicializa cada variável de instância
	 * como String para titulo e um arrayList para guarda musicas na playList.
	 * @param tituloPlayList
	 * @throws TituloInvalidoException
	 */
	public PlayList(String tituloPlayList) throws TituloInvalidoException {
		if (tituloPlayList == null || tituloPlayList.trim().isEmpty()) {
			throw new TituloInvalidoException("Titulo da playList");
		}
		this.playList = new ArrayList<>();
		this.tituloPlayList = tituloPlayList;
	}
	/**
	 * metodo para adicionar o objeto musica no arrayList de playList
	 * @param musica
	 * @return boolean
	 * @throws MusicaInvalidaException em caso de musica invalida
	 */
	public boolean adicionaMusica(Musica musica) throws MusicaInvalidaException {
		if (musica == null) {
			throw new MusicaInvalidaException();
		}
		return this.playList.add(musica);
	}
	/**
	 * metodo para verificar se contem uma musica no arrayList de playList
	 * @param musica
	 * @return boolean
	 * @throws MusicaInvalidaException em caso de musica invalida
	 */
	public boolean contemMusica(String musica) throws MusicaInvalidaException {
		if (musica == null || musica.trim().isEmpty()) {
			throw new MusicaInvalidaException();
		}
		for (Musica music : playList) {
			if (music.getTituloMusica().equals(musica)) {
				return true;
			}
		}
		return false;

	}
	/**
	 * metodo para remover uma musica no arayList de playList pelo indice.
	 * @param faixa
	 * @return boolean
	 * @throws FaixaInvalidaException em caso de uma faixa invalida.
	 */
	public boolean removeMusica(int faixa) throws FaixaInvalidaException {
		if (faixa < 1) {
			throw new FaixaInvalidaException();
		}
		playList.remove(faixa - 1);
		return true;
	}
	/**
	 * metodo para ver a duracao de todas as musicas contida na playList.
	 * @return integer
	 */
	public int getDuracaoTotal() {
		int duracao = 0;
		for (Musica musica : playList) {
			duracao += musica.getDuracaoEsperada();
		}
		return duracao;
	}
	/**
	 * metodo para ver a quantidade de musicas no arrayList de playList.
	 * @return integer
	 */
	public int quantidaDeFaixas() {
		return playList.size();

	}

	public ArrayList<Musica> getPlayList() {
		return playList;
	}

	public void setPlayList(ArrayList<Musica> playList) {
		this.playList = playList;
	}

	public String getNomePlayList() {
		return tituloPlayList;
	}

	public void setNomePlayList(String tiuloPlayList) {
		this.tituloPlayList = tiuloPlayList;
	}

}
