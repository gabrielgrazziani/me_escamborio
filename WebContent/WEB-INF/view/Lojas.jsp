<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lojas</title>
</head>
<body>
	
	<a href="FormLogin"><input type="button" value="login"></a>
	<h1>Lojas</h1>
	
	<c:forEach items="${lojas}" var="loja">
		<a href="ListarProdutosLoja?id=${loja.id}">${loja.loja}</a>
	</c:forEach>

</body>
</html>