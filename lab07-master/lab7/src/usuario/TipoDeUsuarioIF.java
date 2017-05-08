package usuario;

import Jogo.Jogo;

public interface TipoDeUsuarioIF {
	/**
	 * metodo para reconpensar um usuario dependendo do jogo e do tipo de
	 * usuario
	 * 
	 * @param jogo
	 * @return
	 */
	public int recompensar(Jogo jogo);

	/**
	 * metodo para punir um usuario dependendo do jogo e do tipo de usuario
	 * 
	 * @param jogo
	 * @return
	 */
	public int punir(Jogo jogo);

	/**
	 * metodo para da desconto a um usuario dependendo do tipo de usuario
	 * 
	 * @param desconto
	 * @return
	 */
	public double desconto(double desconto);

	/**
	 * metodo para x2p um usuario dependendo do tipo de usuario
	 * 
	 * @param valor
	 * @return
	 */
	public int x2p(int valor);

}
