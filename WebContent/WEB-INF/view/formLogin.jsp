<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mercadorigens - Login</title>
	<link href="estilo.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="header"><h1>MERCADORIGEM</h1></div>
		<form>
			<button class="button" style="width:100%;" formaction="ListarLojas">Voltar à página inicial</button>
		</form>
	</header>
	<div class="center"><h2 style="text-align: center;">Fazer Login</h2>
		<form action="Login" method="post">
		    <label for="fname">E-mail</label><br>
		    <input type="email" id="email" name="email" required >
		    <label for="fname2">Senha</label><br>
		    <input type="password" name="senha" required>
		    <input type="submit" value="login">
	    </form>
	    <h4 style="text-align: center;"><a href="FormCadastro">Registrar-se</a></h4>
    </div>
</body>
</html>