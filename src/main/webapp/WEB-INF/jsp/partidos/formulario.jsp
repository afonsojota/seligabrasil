<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transparência Brasil</title>
</head>
<body>
	
	<h1>Consulta quantidade de processos por partido</h1>
	
	<form method="post" action="${linkTo[PartidosController].estatisticas}">
		<p>
			<label>Casa:</label>
			<select name="casa">
			<c:forEach items="${casas}" var="casa">
				<option value="${casa.codigo}">${casa.descricao}</option>
			</c:forEach>
			</select>
		</p>
		
		<p>
			<label>Estado:</label>
			<input type="text" name="estado" />
		</p>
		
		<button type="submit">Enviar</button>
	</form>
	
</body>
</html>