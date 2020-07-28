package br.com.livraria.negocio;

import java.util.ArrayList;
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
	
}
