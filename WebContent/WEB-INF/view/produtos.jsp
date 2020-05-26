<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lojas</title>
</head>
<body>

	<h1>Produtos</h1>
	
	<ul>
	<c:forEach items="${produtos}" var="produto">
		<li>
			produto: <a href="FormMensagem?idProduto=${produto.id}">${produto.nome}</a>
			preço: ${produto.preco}
		</li>
	</c:forEach>
	</ul>
</body>
</html>