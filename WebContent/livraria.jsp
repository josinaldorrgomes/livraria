<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<br>
		<hr>
		<p><b>Livraria Online</b></p>
		<c:url var="url" value="/livros/catalogo" />
		<p><b><a href="${url}?Add=">Iniciar compras</a></b></p>
	</div>
	<div>
		<em>Copyright &copy; 2020 Livraria Virtual</em>
	</div>
</body>
</html>