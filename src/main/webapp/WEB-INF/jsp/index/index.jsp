<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>VRaptor Blank Project</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
</head>

<body>
	<h1>Candidatos</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<p>
					<label for="estado"><b>Estado:</b></label> <select id="estado"
						name="estado">
						<c:forEach items="${estados}" var="estado">
							<option value="${estado.sigla}">${estado.nome}</option>
						</c:forEach>
					</select>
				</p>
	
				<p>
					<label for="partido">Partido:</label> <select id="partido"
						name="partido">
						<option value="0">Todos</option>
						<c:forEach items="${partidos}" var="partido">
							<option value="${partido.partidoId}">${partido.sigla}</option>
						</c:forEach>
					</select>
				</p>
	
				<p>
					<label for="cargo">Cargo:</label> <select id="cargo" name="cargo">
						<option value="0">Todos</option>
						<c:forEach items="${cargos}" var="cargo">
							<option value="${cargo.cargoId}">${cargo.nome}</option>
						</c:forEach>
					</select>
				</p>
				
				<p>
					<input type="text" name="nomeCandidato" placeholder="Nome do candidato" />
				</p>
			</div>
			
			<div class="col-md-8">
				<h3>resultado da busca</h3>
			</div> 		
		</div>
		
		<div class="row">
			<div class="col-md-3">
				<a role="button" class="btn btn-primary btn-lg">Buscar</a>
			</div>
		</div>
		
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>

</html>