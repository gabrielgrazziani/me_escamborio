<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mercadorigens - Loja</title>
	<link href="estilo.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="header"><h1>MERCADORIGEM</h1></div>

		<a href="ListarLojas"><button class="button">Voltar à página inicial</button></a><a href="ListarProdutosLoja?id=${produto.loja.id}"><button class="button">Voltar à página da loja</button></a>
		
	</header>
	<main>
		<h2>${produto.loja.loja}</h2>
		<div class="center2">
			<h2>${produto.nome}</h2>
			<p>Descrição do Produto: ${produto.descricao}</p>
			<p>Preço: ${produto.preco}</p>
			<p>Envie uma mensagem para o vendedor se tiver interesse no
				produto:</p>
			<h3>
				<form action="CriaMensagem" method="post">
					<label for="fname">Nome</label> 
					<input style="width: 25%" type="text" id="nome" name="nomeComprador" required>
					 
					<label for="fname2">Whatsapp</label> 
					<input style="width: 25%" type="tel" id="numero" name="telefone" required>
					
					<label	for="fname3">Quantidade</label>
					<input style="width: 25%" type="number" id="quantidade" name="quantidade" required><br>
					
					<label for="fname4">Mensagem</label>
					<textarea name="mensagem"></textarea>
					<input type="hidden" name="idProduto" value="${produto.id}">
					<input type="submit" value="Enviar">
				</form>
			</h3>
		</div>
	</main>
</body>
</html>