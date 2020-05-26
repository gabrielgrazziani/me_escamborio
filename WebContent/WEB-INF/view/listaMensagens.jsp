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
	<c:forEach items="${loja.mensagens}" var="mensagem">
		<p>${mensagem.comprador} quer ${mensagem.quantidade} Quantidade(s) de ${mensagem.produto.nome} que custa ${mensagem.produto.preco} por unidade.</p>
		<p>WhatsApp: ${mensagem.telefone}</p>
		<p>Data-Hora: ${mensagem.dataTime}</p>
		<p>Mensagem: ${mensagem.mensagem}</p>
	</c:forEach>
</body>
</html>