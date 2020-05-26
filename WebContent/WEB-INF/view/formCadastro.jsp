<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CriaLoja" method="post">
		<label>
			Nome Logísta
			<input type="text" name="nomeLogista" required >
		</label>
		<label>
			Nome Loja
			<input type="text" name="nomeLoja" required >
		</label>
		<label>
			E-mail
			<input type="email" name="email" required >
		</label>
		<label>
			Senha
			<input type="password" name="senha" required>
		</label>
		<label>
			Repetir a Senha
			<input type="password" name="repetiSenha" required>
		</label>
		<input type="submit" value="Cadastrar">
		<a href="ListarLojas"><input type="button" value="Cancelar"></a>
	</form>
</body>
</html>