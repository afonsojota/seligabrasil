<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VRaptor Blank Project</title>
</head>
<body>
	<h1>Candidatos</h1>
	
	<select name="estado">
		<c:forEach items="${estados}" var="estado">
			<option value="${estado.sigla}">${estado.nome}</option>
		</c:forEach>
	</select>
	
	<select name="partido">
		<c:forEach items="${partidos}" var="partido">
			<option value="${partido.partidoId}">${partido.sigla}</option>
		</c:forEach>
	</select>
	
	<select name="cargo">
		<c:forEach items="${cargos}" var="cargo">
			<option value="${cargo.cargoId}">${cargo.nome}</option>
		</c:forEach>
	</select>
	
	<button>Buscar</button>
</body>
</html>