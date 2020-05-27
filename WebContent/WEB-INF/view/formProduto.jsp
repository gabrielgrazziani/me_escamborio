<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form action="CriaProduto" method="post">
			<label>
				Nome:
				<input type="text" name="nomeProduto" required >
			</label>
			<label>
				Preço:
				<input type="number" name="preco" required>
			</label>
			<label>
				Descrição:
				<textarea rows="8" cols="30" name="descricao"></textarea>
			</label>
			<input type="submit" value="Cadastrar">
			<a href="HomeLoja"><input type="button" value="Cancelar"></a>
		</form>
	</main>
</body>
</html>