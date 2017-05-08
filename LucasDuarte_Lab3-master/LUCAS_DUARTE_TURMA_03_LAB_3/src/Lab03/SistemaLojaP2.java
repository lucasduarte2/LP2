/* 115210384 - LUCAS VENANCIO DUARTE: LAB 3 - Turma 3 */
package Lab03;

public class SistemaLojaP2 {

	private Estoque estoque;
	private int produtosCadastrados;
	private double arrecadadoVenda;

	public SistemaLojaP2() {
		this.estoque = new Estoque();
		this.arrecadadoVenda = 0.0;
		this.produtosCadastrados = 0;
	}

	// cadastrando os produtos
	public void Cadastro() {
		Leitura teclado = new Leitura();
		String outroProduto = "";
		System.out.println("= = = = Cadastro de Produtos = = = = ");

		while (!outroProduto.equalsIgnoreCase("nao")) {

			System.out.print("Digite o nome do produto: ");
			String nomeProduto = teclado.leituraFrase();

			System.out.print("Digite o preco unitario do produto: ");
			double preco = teclado.leituraDouble();

			System.out.print("Digite o tipo do produto: ");
			String tipo = teclado.leituraFrase();

			System.out.print("Digite a quantidade no estoque: ");
			int quantidade = teclado.leituraInteiro();

			if (estoque.produtoExistente(nomeProduto, preco, quantidade) != true) {
				Produto produto = new Produto(nomeProduto, tipo, preco, quantidade);
				estoque.insereProduto(produto, produtosCadastrados);
				produtosCadastrados++;

			}

			System.out.println(LojaoP2.FIM_DE_LINHA + quantidade + " produto(s)" + " \"" + nomeProduto + "\""
					+ " cadastrado com sucesso." + LojaoP2.FIM_DE_LINHA);
			System.out.print("Deseja cadastrar outro produto? ");

			String opcao = teclado.leituraPalavra();
			// condicao para saber se foi digitado a opcao valida
			while (!opcao.equalsIgnoreCase("nao") && !opcao.equalsIgnoreCase("sim")) {
				System.out.println("Opcao invalida, digite uma opcao valida");
				System.out.print(LojaoP2.FIM_DE_LINHA + "Deseja cadastrar outro produto? ");
				opcao = teclado.leituraPalavra();
			}
			if (opcao.equalsIgnoreCase("nao")) {
				outroProduto = "nao";
			}
			System.out.println("");
		}
	}

	// venda dos produtos
	public void venda() {
		Leitura teclado = new Leitura();
		System.out.println("= = = = Venda de Produtos = = = =");

		String outroProduto = "";
		while (!outroProduto.equalsIgnoreCase("nao")) {

			System.out.print("Digite o nome do produto: ");
			String produtoPedido = teclado.leituraFrase();
			if (estoque.pesquisaProduto(produtoPedido) == true) {
				System.out.print("Digite a quantidade que deseja vender: ");
				int quantPedida = teclado.leituraInteiro();
				estoque.quantidadeProduto(produtoPedido, quantPedida);
				arrecadacaoVenda(quantPedida, produtoPedido);
			}

			System.out.print(LojaoP2.FIM_DE_LINHA + "Deseja vender outro produto? ");
			String opcao = teclado.leituraFrase();
			// condicao para saber se foi digitado a opcao valida
			while (!opcao.equalsIgnoreCase("nao") && !opcao.equalsIgnoreCase("sim")) {
				System.out.println("Opcao invalida, digite uma opcao valida");
				System.out.print(LojaoP2.FIM_DE_LINHA + "Deseja vender outro produto? ");
				opcao = teclado.leituraPalavra();
			}

			if (!opcao.equalsIgnoreCase("sim")) {
				outroProduto = "nao";
			}
			System.out.println("");
		}
	}

	// calcula quanto foi arrecadado na venda do produto
	public void arrecadacaoVenda(int quantProduto, String nomeProduto) {

		for (int i = 0; i < produtosCadastrados; i++) {
			if (estoque.getProdutos()[i].getNome().equals(nomeProduto)) {
				arrecadadoVenda += estoque.getProdutos()[i].getPreco() * quantProduto;

			}
		}
	}

	// imprimindo o balanco
	public void balanco() {
		System.out.println("= = = = Impressao de Balanco = = = = ");
		System.out.println("Produtos cadastrados");

		for (int i = 0; i < produtosCadastrados; i++) {
			System.out.println((i + 1) + ") " + estoque.toString(i));
		}

		System.out.println(LojaoP2.FIM_DE_LINHA + "Total arrecadado em vendas: R$ " + arrecadadoVenda);
		System.out.println("Total que pode ser arrecadado: R$ " + estoque.totalAFatura() + LojaoP2.FIM_DE_LINHA);
	}

}