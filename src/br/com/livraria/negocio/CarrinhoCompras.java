package br.com.livraria.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoCompras {

	Map<String, ItemCompra> itens;
	
	public CarrinhoCompras() {
		itens = new HashMap<String, ItemCompra>();
	}

	public synchronized void adicionar(Livro livro) {
		if (itens.containsKey(livro.getIdLivro())) {
			ItemCompra item = itens.get(livro.getIdLivro());
			item.incrementaQuantidade();
		} else {
			ItemCompra novoItem = new ItemCompra(livro);
			itens.put(livro.getIdLivro(), novoItem);
		}
	}
	
	public synchronized void remover(String idLivro) {
		if (itens.containsKey(idLivro)) {
			ItemCompra item = itens.get(idLivro);
			item.decrementaQuantidade();
			if (item.getQuantidade() <= 0) {
				itens.remove(idLivro);
			}
		}
	}
	
	public synchronized List<ItemCompra> getItens() {
		List<ItemCompra> resultado = new ArrayList<ItemCompra>();
		resultado.addAll(this.itens.values());
		return resultado;
	}
	
	protected void finalize() throws Throwable {
		itens.clear();
	}
	
	public synchronized int getNumeroItens() {
		int numeroItens = 0;
		for (ItemCompra item : getItens()) {
			numeroItens += item.getQuantidade();
		}
		return numeroItens;
	}
	
	public synchronized double getTotal() {
		double total = 0.0;
		for (ItemCompra item : getItens()) {
			Livro livro = item.getItem();
			total += (item.getQuantidade() * livro.getPreco());
		}
		return total;
	}
	
	public void limpar() {
		itens.clear();
	}

}
