package br.com.livraria.negocio;

public class ItemCompra {

	private Livro item;
	private int quantidade;

	public ItemCompra(Livro prod) {
		this.item = prod;
		this.quantidade = 1;
	}

	public void incrementaQuantidade() {
		quantidade++;
	}

	public void decrementaQuantidade() {
		quantidade--;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Livro getItem() {
		return item;
	}

}
