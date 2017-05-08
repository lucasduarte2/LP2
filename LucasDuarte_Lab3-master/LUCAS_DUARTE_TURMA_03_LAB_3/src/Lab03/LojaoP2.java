/* 115210384 - LUCAS VENANCIO DUARTE: LAB 3 - Turma 3 */
package Lab03;

public class LojaoP2 {
	private static SistemaLojaP2 sistema = new SistemaLojaP2();
	public static final String FIM_DE_LINHA = System.lineSeparator();

	public static void main(String[] args) {
		
		final int OPCAO1 = 1, OPCAO2 = 2, OPCAO3 = 3, OPCAO4 = 4;
		LojaoP2 Teclado = new LojaoP2();
		int entradaUsuario;
		
		while (OPCAO4 != (entradaUsuario = Teclado.EconomizaP2())) {

			if (OPCAO1 == (entradaUsuario)) {
				sistema.Cadastro();

			} else if (OPCAO2 == (entradaUsuario)) {
				sistema.venda();

			} else if (OPCAO3 == (entradaUsuario)) {
				sistema.balanco();

			} else {
				System.out.println("Opcao invalida, escolha uma opcao valida" + FIM_DE_LINHA);
			}
		}
		System.out.println("Fim da operacao");
	}

	private int EconomizaP2() {
		System.out.println("= = = = Bem-vindo(a) ao EconomizaP2 = = = =" + FIM_DE_LINHA 
				+ "Digite a opcao desejada:" + FIM_DE_LINHA 
				+ "1 - Cadastrar um Produto" + FIM_DE_LINHA 
				+ "2 - Vender um Produto" + FIM_DE_LINHA
				+ "3 - Imprimir Balanco" + FIM_DE_LINHA 
				+ "4 - Sair" + FIM_DE_LINHA );
		System.out.print("Opcao: ");
		Leitura teclado = new Leitura();
		int entrada = teclado.leituraInteiro();
		return entrada;
	}
	
}