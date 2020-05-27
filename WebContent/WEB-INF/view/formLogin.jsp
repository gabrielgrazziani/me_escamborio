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
		<h1><a href="ListarLojas">Mercadorigem</a></h1>
	</header>
	<main>
		<form action="Login" method="post">
			<label>
				E-mail
				<input type="email" name="email" required >
			</label>
			<label>
				Senha
				<input type="password" name="senha" required>
			</label>
			<input type="submit" value="Logar">
			<a href="FormCadastro"><input type="button" value="Criar conta"></a>
		</form>
	</main>
</body>
</html>