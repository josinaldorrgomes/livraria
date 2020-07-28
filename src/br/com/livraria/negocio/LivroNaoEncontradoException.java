package br.com.livraria.negocio;

public class LivroNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public LivroNaoEncontradoException(String msg) {
		super(msg);
	}

}
