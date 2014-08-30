<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transparência Brasil</title>
</head>
<body>
	
	<h1>Lista de partidos disponíveis</h1>
	
	<ul>
		<c:forEach items="${partidos}" var="partido">
			<li>
			${partido.partidoId} - ${partido.sigla}
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>