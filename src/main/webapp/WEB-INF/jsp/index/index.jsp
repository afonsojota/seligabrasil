<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>VRaptor Blank Project</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<style>
	.candidato {
		display: none;
	}
</style>

</head>

<body>
	<h1>Candidatos</h1>
	<div class="container">
		<div class="row">
			<form id="pesquisa" method="post" action="${linkTo[IndexController].pesquisar}">
				<div class="col-md-4">
					<p>
						<label for="estado"><b>Estado:</b></label> 
						<select id="estado"
							name="estado">
							<c:forEach items="${estados}" var="estado">
								<option value="${estado.sigla}">${estado.nome}</option>
							</c:forEach>
						</select>
					</p>
		
					<p>
						<label for="partido">Partido:</label> 
						<select id="partido"
							name="partido">
							<option value="0">Todos</option>
							<c:forEach items="${partidos}" var="partido">
								<option value="${partido.partidoId}">${partido.sigla}</option>
							</c:forEach>
						</select>
					</p>
		
					<p>
						<label for="cargo">Cargo:</label> 
						<select id="cargo" name="cargo">
							<option value="0">Todos</option>
							<c:forEach items="${cargos}" var="cargo">
								<option value="${cargo.cargoId}">${cargo.nome}</option>
							</c:forEach>
						</select>
					</p>
					
					<p>
						<input type="text" name="nomeCandidato" placeholder="Nome do candidato" />
					</p>
					
					<input type="hidden" name="pagina" id="pagina" value="1"/>
					
					<a id="btPesquisar" role="button" class="btn btn-primary btn-lg">Buscar</a>
					
				</div>
			</form>
			
			<div class="col-md-8" id="candidatos">
				<h3>resultado da busca</h3>
				
				<div class="candidato row">
					<div class="col-md-2">
						<img class="image" />
					</div>
					<div class="col-md-5">
						<label>Nome:</label>
						<label class="nome"></label>
					</div>
				</div>
				
				<ul class="pager">
			  		<li><a href="#" id="prev">Previous</a></li>
			  		<li><a href="#" id="next">Next</a></li>
				</ul>
				
			</div> 		
		</div>
		
		<div class="row">
		
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<script>
		$(function() {
			var form = $('#pesquisa');
			
			var search = function() {
				$.ajax({
					type: 'POST',
					url: form.attr('action'),
					data: form.serialize(),
					success: function(data) {
						if (data.resultado.length > 0) {
							var candidatos = data.resultado;
							$(candidatos).each(function(idx, candidato) {
								var template = $('.candidato').clone();
								template.removeClass('candidato');
								template.css('display', 'block');
								template.find('.image').attr('src', candidato.foto);
								template.find('.nome').html(candidato.nome);
								
								$('#candidatos').append(template);
							});
						}
					},
					
					error: function(data) {
						console.log(data);						
					}
				});		
			};

			$('#next').click(function(evt) {
				var page = $('#page').val();
				$('#page').val(ParseInt(page, 10) + 1);
				search();
			});

			$('#prev').click(function(evt) {
				var page = $('#page').val();
				$('#page').val(ParseInt(page, 10) - 1);
				search();
			});
			
			$('#btPesquisar').click(function(evt) {
				search();
			});
			
		});
	</script>
</body>

</html>