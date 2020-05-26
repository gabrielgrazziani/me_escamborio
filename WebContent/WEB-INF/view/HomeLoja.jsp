<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="Logout"><input type="button" value="logout"></a>
	<a href="FormProduto"><input type="button" value="castrar produto"></a>
	<a href="ListaMensagens"><input type="button" value="mensagens"></a>
	<c:forEach items="${loja.produtos}" var="produto">
		<li>
			produto: <a href="FormEditaProduto?idProduto=${produto.id}">${produto.nome}</a>
			preço: ${produto.preco}
			descrição: ${produto.descricao}
		</li>
	</c:forEach>
</body>
</html>