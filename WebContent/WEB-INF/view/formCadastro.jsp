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
		<div class="header"><h1>MERCADORIGEM</h1></div>
		<form>
			<button class="button" style="width:100%;" formaction="ListarLojas">Voltar à página inicial</button>
		</form>
	</header>
	<main class="center">
		<h2 style="text-align: center;">Registrar-se</h2>
		<form action="CriaLoja" method="post" onsubmit="return validarSenha()">
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
				<input type="password" id="senha" name="senha" required>
			</label>
			<label>
				Confirmar Senha
				<input type="password" id="repetiSenha" name="repetiSenha" required>
			</label>
			<input type="submit" value="Registrar">
			<h5 style="text-align: center;">Já possui uma conta?<a href="FormLogin">Fazer Login</a></h5>
		</form>
	</main>
	<script type="text/javascript">
	function validarSenha(){
			senha = document.getElementById('senha').value;
			repetiSenha = document.getElementById('repetiSenha').value;
		   	if (senha != repetiSenha) {
		    	alert("AS SENHAS SÃO DIFERENTES!\nFAVOR DIGITAR SENHAS IGUAIS");
		    	return false;
		   	}
		   	return true;
	}
	</script>
</body>
</html>