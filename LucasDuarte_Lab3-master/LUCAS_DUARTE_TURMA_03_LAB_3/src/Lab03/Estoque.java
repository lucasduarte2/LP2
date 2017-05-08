/* 115210384 - LUCAS VENANCIO DUARTE: LAB 3 - Turma 3 */
package Lab03;

public class Estoque {

	private Produto[] produtos;

	public Estoque() {
		this.produtos = new Produto[8];
	}

	// aumenta o tamanho do array produtos
	public void aumentaArray() {
		if (produtos.length >= 8) {

			Produto[] novoArray = new Produto[produtos.length + 8];
			for (int i = 0; i < produtos.length; i++) {
				novoArray[i] = produtos[i];
			}
			produtos = novoArray;
		}
	}

	// inserindo os produtos no array Produtos
	public void insereProduto(Produto produto, int indice) {
		this.produtos[indice] = produto;
	}

	// verifica se o produto existe, caso exista ele altera o preco e aumenta a quantidade
	public boolean produtoExistente(String nomeProduto, double preco, int quantidade) {
		for (Produto produto : produtos) {
			if (produto == null || !(produto.getNome().equals(nomeProduto))) {
				return false;

			} else if (produto.getNome().equals(nomeProduto)) {
				produto.setPreco(preco);
				produto.setQuantidade(produto.getQuantidade() + quantidade);
				return true;
			}
		}
		return false;

	}

	// pesquisa se o produto ta cadastrado no sistema
	public boolean pesquisaProduto(String nomeProduto) {
		for (Produto produto : produtos) {
			if (produto == null) {
				System.out.println("==> " + nomeProduto + " nao cadastrado no sistema.");
				return false;

			} else if (produto.getNome().equals(nomeProduto)) {
				System.out.println("==> " + nomeProduto + " (" + produto.getTipo() + ").R$" + produto.getPreco());
				return true;
			}
		}
		return false;

	}

	// verifica se existe a quantidade pedida no estoque
	public void quantidadeProduto(String produtoPedido, int quantPedida) {
		for (Produto produto : produtos) {
			if (produto == null) {
				return;
			}
			if (produto.getNome().equals(produtoPedido) && quantPedida <= produto.getQuantidade()) {
				produto.setQuantidade(produto.getQuantidade() - quantPedida);
				return;

			} else {
				System.out.println("Nao e possivel vender pois nao ha " + produto.getNome() + " suficiente."
						+ LojaoP2.FIM_DE_LINHA);
			}
		}

	}

	// calcula o quanto pode ser arrecado ainda
	public double totalAFatura() {
		int valor = 0;
		for (Produto produto : produtos) {
			if (produto == null) {
				return valor;
			} else {
				valor += produto.getPreco() * produto.getQuantidade();
			}
		}
		return valor;

	}

	public String toString(int i) {
		return produtos[i].toString() + " Restante: " + produtos[i].getQuantidade();
	}

	public Produto[] getProdutos() {
		return produtos;
	}

}