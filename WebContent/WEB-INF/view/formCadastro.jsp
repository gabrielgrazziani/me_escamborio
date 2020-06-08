<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mercadorigens - Registro</title>
	<link href="estilo.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="header"><h1 style="color: #900000; text-align: center;" >MERCADORIGENS</h1></div>
	</header>
	<main class="center">
		<h2 style="text-align: center;">Registrar-se</h2>
		<form action="CriaLoja" method="post">
			<label>
				Nome do Vendedor
				<input type="text" name="nomeLogista" required >
			</label>
			<label>
				Nome da Loja
				<input type="text" name="nomeLoja" required >
			</label>
			<label>
				E-mail
				<input type="email" id="email" name="email" required >
			</label>
			<label>
				Senha
				<input type="password" name="senha" required>
			</label>
			<label>
				Confirmar Senha
				<input type="password" name="repetiSenha" required>
			</label>
			<input type="submit" value="Registrar">
			<h5 style="text-align: center;">Já possui uma conta?<a href="FormLogin">Fazer Login</a></h5>
		</form>
	</main>
	
</body>
</html>