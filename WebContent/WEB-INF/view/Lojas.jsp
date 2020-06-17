<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mercadorigens</title>
	<link href="estilo.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="header">
			<h1 style="color: #900000; text-align: center;">
				MERCADORIGENS
			</h1>
		</div>
		<form>
			<button class="button" formaction="FormLogin">Sou Lojista</button><button class="button" formaction="sobre.html">Sobre</button>
		</form>
	</header>
	<main>
		<ul>
		<c:forEach items="${lojas}" var="loja">
			<li class="tcenter"><a class="li" href="ListarProdutosLoja?id=${loja.id}">${loja.loja}</a></li>
		</c:forEach>
		</ul>
	</main>
</body>
</html>