package usuario;

import Jogo.Jogabilidade;
import Jogo.Jogo;
import excecoes.JogoInvalidoException;
import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.SaldoInsuficienteException;

public class Veterano implements TipoDeUsuarioIF {
	
	public static final double DESCONTO_VETERANO = 0.8;
	public static final int MULTIPLICAX2P = 15;

	/**
	 * 
	 */
	//chamada polimórfica
	@Override
	public int recompensar(Jogo jogo) {
		int recompensa = 0;
		
		if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE)){
			recompensa += 10;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)){
			recompensa += 20;
		}
		return recompensa;
	}

	/**
	 * 
	 */
	//chamada polimórfica
	@Override
	public int punir(Jogo jogo) {
		int punir = 0;
		
		if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)) {
			punir -= 20;
			
		}
		if(jogo.getJogabilidade().contains(Jogabilidade.OFFLINE)){
			punir -= 20;
		}
		return punir;
	}

	/**
	 * 
	 */
	//chamada polimórfica
	@Override
	public double desconto(double desconto) {
		
		return desconto * DESCONTO_VETERANO;
	}

	/**
	 * 
	 */
	//chamada polimórfica
	@Override
	public int x2p(int valor) {
		
		return valor * MULTIPLICAX2P;
	}
}
