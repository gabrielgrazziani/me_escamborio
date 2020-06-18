<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mensagens</title>
<link href="estilo.css" rel="stylesheet">
</head>

<body>
	<header>
		<div class="header">
			<h1>MERCADORIGEM</h1>
		</div>
		<a href="HomeLoja">
			<button class="button" style="width: 100%;" formaction="lojista.html">
				Voltar à página da Loja</button>
		</a>
		<h2 class="nome_loja">${loja.loja }</h2>
		<h3 class="logout">
			<a href="Logout">Sair</a>
		</h3>
	</header>

	<main>
		<ul>
			<c:forEach items="${loja.mensagens}" var="mensagem">
					
				<li><div class="center2">
					<p>${mensagem.comprador} quer ${mensagem.quantidade} quantidade(s) de ${mensagem.produto.nome} que custa R$ ${mensagem.produto.preco} por unidade</p>
					
					<fmt:parseDate value="${mensagem.dataTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
					<p>Whatsapp: ${mensagem.telefone}  Data e hora: <fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ parsedDateTime }" /></p>
					
					<p>Mensagem: ${mensagem.mensagem} </p>

    				<a class="not_hover" href="ExcluirMensagem?idMensagem=${mensagem.id}">
    					<button class="button3" >Excluir Mensagem</button>
    				</a>
				</div></li>
				
			</c:forEach>
		</ul>
	</main>
</body>
</html>