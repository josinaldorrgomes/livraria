package br.com.livraria.negocio;

import java.util.List;

public class LivrariaBean {

	private Livraria sistema = null;
	private String idLivro = "0";
	
	public LivrariaBean() {
	}

	public void setSistema(Livraria livraria) {
		this.sistema = livraria;
	}

	public void setIdLivro(String idLivro) {
		this.idLivro = idLivro;
	}

	public Livro getLivro() throws LivroNaoEncontradoException {
		return sistema.getLivro(idLivro);
	}

	public List<Livro> getLivros() {
		return sistema.getLivros();
	}

	public void comprarLivros(CarrinhoCompras cart) throws CompraException {
		sistema.comprarLivros(cart);
	}

}
