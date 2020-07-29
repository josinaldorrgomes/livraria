<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Minha livraria virtual</title>
</head>
<body bgcolor="#FFFFFF">
	<div>
		<hr>
		<br>
		<h1>
			<img width="100" src="img/livro.png">
			<font size="+3">Minha Livraria Virtual</font>
			<img width="100" src="img/livro.png">
		</h1>
	</div>
	<div>
		<jsp:useBean id="livrariaBean" class="br.com.livraria.negocio.LivrariaBean" scope="page">
			<jsp:setProperty property="sistema" name="livrariaBean" value="${sistemaLivraria}"/>
		</jsp:useBean>
		<c:if test="${not empty param.Add}">
			<c:set var="idL" value="${param.Add}"/>
			<jsp:setProperty property="idLivro" name="livrariaBean" value="${idL}"/>
			<c:set var="livroAdicionado" value="${livrariaBean.livro}"/>
			<h3>
				<font color="red" size="+2">Você adicionou o livro <em>${livroAdicionado.titulo}</em> ao seu carrinho de compras.</font>
			</h3>
		</c:if>
		<c:choose>
			<c:when test="sessionScope.cart.numeroItens > 0">
				<c:url var="url" value="/livros/mostrarCarrinho">
					<c:param name="limpar" value="0"/>
					<c:param name="remover" value="0"/>
				</c:url>
				<p>
					<a href="${url}">Ver carrinho de compras</a>
					<c:url var="url" value="/livros/comprar"/>
					<a href="${url}">Finalizar compras</a>
				</p>
			</c:when>
			<c:otherwise>
				Seu carrinho de compras está vazio.
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<em>Copyright &copy; 2020 Livraria Virtual</em>
	</div>
</body>
</html>