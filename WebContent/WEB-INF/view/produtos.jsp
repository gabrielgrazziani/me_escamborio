<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="estilo.css" rel="stylesheet">
	<title>Mercadorigens - Loja</title>
</head>
<body>
	<header>
		<div class="header">
			<h1>MERCADORIGEM</h1>
		</div>
		<form>
			<button class="button" style="width:100%;" formaction="ListarLojas">Voltar à página inicial</button>
		</form>
	</header>
	<main>
		<h2>${loja }</h2>
		
		<ul>
		<c:forEach items="${produtos}" var="produto">
			<li>
				<a class="li" href="FormMensagem?idProduto=${produto.id}">
					${produto.nome}
					<div class="c" >
						<p>Preço: ${produto.preco}</p>
						<img alt="${produto.nome}" src="file/${produto.imagem}" width="140px">
					</div>
				</a>
			</li>
		</c:forEach>
		</ul>
	</main>	
</body>
</html>