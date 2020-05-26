<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Nome: ${produto.nome}</h1>
	<p>Preço: ${produto.preco}</p>
	<p>Descrição: ${produto.descricao}</p>
	
	<form action="CriaMensagem" method="post">
		<label>
			Nome:
			<input type="text" name="nomeComprador" required >
		</label>
		<label>
			Quantidade:
			<input type="number" name="quantidade" required>
		</label>
		<label>
			WhatsApp:
			<input type="tel" name="telefone" required>
		</label>
		<label>
			Mensagem:
			<textarea rows="8" cols="30" name="mensagem"></textarea>
		</label>
		<input type="hidden" name="idProduto" value="${produto.id}">
		<input type="submit" value="Enviar">
	</form>
</body>
</html>