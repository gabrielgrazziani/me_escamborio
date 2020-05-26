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
	<form action="EditaProduto" method="post">
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
		<input type="hidden" name="idProduto" value="${produto.id}">
		<input type="submit" value="Editar">
		<a href="HomeLoja"><input type="button" value="Cancelar"></a>
	</form>

</body>
</html>