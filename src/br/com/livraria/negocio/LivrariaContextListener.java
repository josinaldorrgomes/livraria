package br.com.livraria.negocio;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LivrariaContextListener implements ServletContextListener {

	public static final String SISTEMA_LIVRARIA = "sistemaLivraria";

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		try {
			Livraria livraria = new Livraria();
			context.setAttribute(SISTEMA_LIVRARIA, livraria);
		} catch (Exception e) {
			System.out.println("O sistema de livraria n�o pode ser publicado no contexto: " + e.getMessage());
		}

	}
	
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		Livraria livraria = (Livraria) context.getAttribute(SISTEMA_LIVRARIA);
		if (livraria != null) {
			livraria.fechar();
		}
		context.removeAttribute(SISTEMA_LIVRARIA);
	}

}