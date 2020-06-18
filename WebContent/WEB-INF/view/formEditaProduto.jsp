<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mercadorigens - Loja</title>
	<link href="estilo.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="header">
			<h1>MERCADORIGEM</h1>
		</div>
	
		<div>
			<a  href="HomeLoja"><button style="width: 100%" class="button">Voltar à página da Loja</button></a>
		</div>
		
		<h2 class="nome_loja">${loja.loja }</h2>
		<h3 class="logout">
			<a href="Logout">Sair</a>
		</h3>
	</header>
	<main>
		<div class="center2">
		<form action="EditaProduto" enctype="multipart/form-data" method="post">
			<a style="display: block;" href="ExcluirProduto?idProduto=${produto.id}"><input type="button" value="Excluir"></a>
			<label>
				Nome:
				<input style="width: 95%" type="text" name="nomeProduto" value="${produto.nome}" required >
			</label>
			<label>
				Preço:
				<input style="width: 95%" type="number" name="preco" value="${produto.preco}" required>
			</label>
			<label>
				Descrição:
				<textarea rows="8" cols="30" name="descricao">${produto.descricao}</textarea>
			</label>
			<input type="file" name="imagem">
			
			<input type="hidden" name="idProduto" value="${produto.id}">
			<input type="submit" value="Editar">
			<a href="HomeLoja"><input type="button" value="Cancelar"></a>
		</form>
		</div>
	</main>
</body>
</html>