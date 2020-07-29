package br.com.livraria.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
		Livro livro1 = new Livro();
		livro1.setIdLivro("0596005407");
		livro1.setAno(2008);
		livro1.setTitulo("Head First Servlets and JSP");
		livro1.setDescricao("Livro sobre Servlets e JSP");
		livro1.setAutores("Bryan Basham, Kathy Sierra, Bert Bates");
		livro1.setQuantidade(10);
		livro1.setPreco(200.5);
		Livro livro2 = new Livro();
		livro2.setIdLivro("9788573935721");
		livro2.setAno(2007);
		livro2.setTitulo("Desenvolvendo Aplicações Web com JSP, Servlets, JavaServer Faces, Hibernate, EJB 3 e AJAX");
		livro2.setDescricao("Livro sobre tecnologias usadas na programação Java para Web");
		livro2.setAutores("Edson Gonçalves");
		livro2.setQuantidade(10);
		livro2.setPreco(110.9);
		estoqueLivros.addAll(Arrays.asList(livro1, livro2));
	}
	
	public List<Livro> getLivros() {
		return Collections.unmodifiableList(estoqueLivros);
	}
	
	public Livro getLivro(String idLivro)  throws LivroNaoEncontradoException {
		Livro livroProcurado = null;
		for (Livro livro : estoqueLivros) {
			if (livro.getIdLivro().equals(idLivro)) {
				livroProcurado = livro;
			}
		}
		if (livroProcurado == null) {
			throw new LivroNaoEncontradoException("Não foi possível encontrar o livro: " + idLivro);
		}
		return livroProcurado;
	}
	
	public void comprarLivros(CarrinhoCompras carrinho) throws CompraException {
		Collection<ItemCompra> itens = carrinho.getItens();
		Iterator<ItemCompra> i = itens.iterator();
		while (i.hasNext()) {
			ItemCompra item = i.next();
			Livro livro = item.getItem();
			String id = livro.getIdLivro();
			int quantidade = item.getQuantidade();
			this.comprarLivro(id, quantidade);
			
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
