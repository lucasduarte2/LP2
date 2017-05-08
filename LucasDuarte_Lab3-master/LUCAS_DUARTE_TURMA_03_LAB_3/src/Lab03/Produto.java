/* 115210384 - LUCAS VENANCIO DUARTE: LAB 3 - Turma 3 */
package Lab03;

public class Produto {

	private String nome, tipo;
	private int quantidade;
	private double preco;

	public Produto(String nome, String tipo, double preco, int quantidade) {
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return getNome() + " (" + getTipo() + ").R$" + getPreco();
	}
}