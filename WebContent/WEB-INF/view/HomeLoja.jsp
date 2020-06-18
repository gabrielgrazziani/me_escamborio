<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<a href="FormProduto"><button class="button">cadastrar produto</button></a><a
			 href="ListaMensagens"><button class="button">mensagens</button></a>
		</div>
	</header>
	<main>
		<h2 class="nome_loja">${loja.loja }</h2>
		<h3 class="logout">
			<a href="Logout">Sair</a>
		</h3>
		<ul>
			<c:forEach items="${loja.produtos}" var="produto">
				<li>
					<a class="li" href="FormEditaProduto?idProduto=${produto.id}">
						${produto.nome}
						<div class="c">
							<p>Preço: ${produto.preco}</p>
							<p>Descrição: ${produto.descricao}</p>
							<img src="file/${produto.imagem}" width="140px">
						</div>
					</a>
				</li>
			</c:forEach>
		</ul>  
	</main>
</body>
</html>