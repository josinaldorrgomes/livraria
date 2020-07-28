package br.com.livraria.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Livraria {

	private List<Livro> estoqueLivros;
	
	public Livraria() {
		estoqueLivros = new ArrayList<Livro>();
		popularLivros();
	}
	
	private void popularLivros() {
		Livro livro = new Livro();
		livro.setIdLivro("0596005407");
		livro.setAno(2008);
		livro.setTitulo("Head First Servlets and JSP");
		livro.setDescricao("Livro sobre Servlets e JSP");
		livro.setAutores("Bryan Basham, Kathy Sierra, Bert Bates");
		livro.setQuantidade(10);
		livro.setPreco(200.5);
		estoqueLivros.add(livro);
		livro = new Livro();
		livro.setIdLivro("9788573935721");
		livro.setAno(2007);
		livro.setTitulo("Desenvolvendo Aplicações Web com JSP, Servlets, JavaServer Faces, Hibernate, EJB 3 e AJAX");
		livro.setDescricao("Livro sobre tecnologias usadas na programação Java para Web");
		livro.setAutores("Edson Gonçalves");
		livro.setQuantidade(10);
		livro.setPreco(110.9);
		estoqueLivros.add(livro);
	}
	
	public List<Livro> getLivros() {
		return Collections.unmodifiableList(estoqueLivros);
	}
	
	public Livro getLivro(String idLivro)  throws LivroNaoEncontradoException {
		Livro livroProcurado = null;
		for (Livro book : estoqueLivros) {
			if (book.getIdLivro().equals(idLivro)) {
				livroProcurado = book;
			}
		}
		if (livroProcurado == null) {
			throw new LivroNaoEncontradoException("Não foi possível encontrar o livro: " + idLivro);
		}
		return livroProcurado;
	}
	
	public void comprarLivros(CarrinhoCompras carrinho) throws CompraException {
		List<ItemCompra> itens = carrinho.getItens();
		Iterator<ItemCompra> i = itens.iterator();
		while (i.hasNext()) {
			ItemCompra item = i.next();
			Livro livro = item.getItem();
			String id = livro.getIdLivro();
			int quantidade = item.getQuantidade();
			comprarLivro(id, quantidade);
			
		}
	}
	
	public void comprarLivro(String idLivro, int qtdComprada) throws CompraException {
		Livro livroSelecionado;
		try {
			livroSelecionado = getLivro(idLivro);
		} catch (LivroNaoEncontradoException e) {
			throw new CompraException(e.getMessage());
		}
		int qtdEstoque = livroSelecionado.getQuantidade();
		if ((qtdEstoque - qtdComprada) >= 0) {
			int novaQtd = qtdEstoque - qtdComprada;
			livroSelecionado.setQuantidade(novaQtd);
		} else {
			throw new CompraException("Livro " + idLivro + "sem estoque sifuciente");
		}
	}

	public void fechar() {
	}
	
}
