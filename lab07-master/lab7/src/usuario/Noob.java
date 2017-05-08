package usuario;

import Jogo.Jogabilidade;
import Jogo.Jogo;
import excecoes.JogoInvalidoException;
import excecoes.LoginInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.SaldoInsuficienteException;

public class Noob implements TipoDeUsuarioIF {

	private final double DESCONTO = 0.90;

	public static final double DESCONTO_NOOB = 0.9;
	public static final int MULTIPLICAX2P = 10;

	//chamada polimórfica
	@Override
	public int recompensar(Jogo jogo) {
		int recompensa = 0;

		if (jogo.getJogabilidade().contains(Jogabilidade.OFFLINE)){
			recompensa += 30;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.MULTIPLAYER)){
			recompensa += 10;
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
		if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE)){
			punir -= 10;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)){
			punir -= 20;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)){
			punir -= 50;
		}
		return punir;
	}


	/**
	 * 
	 */
	//chamada polimórfica
	@Override
	public double desconto(double desconto) {
		
		return desconto * DESCONTO_NOOB;
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
