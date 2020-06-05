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
	<header>
		<h1><a href="HomeLoja">Mercadorigem</a></h1>
		<a href="Logout"><input type="button" value="logout"></a>
	</header>
	<main>
		<form action="EditaProduto" enctype="multipart/form-data" method="post">
			<a href="ExcluirProduto?idProduto=${produto.id}"><input type="button" value="Excluir"></a>
			<label>
				Nome:
				<input type="text" name="nomeProduto" value="${produto.nome}" required >
			</label>
			<label>
				Preço:
				<input type="number" name="preco" value="${produto.preco}" required>
			</label>
			<label>
				Descrição:
				<textarea rows="8" cols="30" name="descricao">${produto.descricao}</textarea>
			</label>
			<img style="height: 120px" alt="${produto.nome}" src="file/${produto.imagem}">
			<input type="file" name="imagem">
			
			<input type="hidden" name="idProduto" value="${produto.id}">
			<input type="submit" value="Editar">
			<a href="HomeLoja"><input type="button" value="Cancelar"></a>
		</form>
	</main>
</body>
</html>