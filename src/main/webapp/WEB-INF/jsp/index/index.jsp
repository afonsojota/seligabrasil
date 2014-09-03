<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>VRaptor Blank Project</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<style>
	.template {
		display: none;
	}

	.candidato {
		margin-bottom: 10px;
		padding: 5px;
		width: inherit;
		background-color: #FEFFE0;
	}
		
	.field {
		white-space: nowrap;
	}
	
	.field-normal {
		white-space: normal;
	}
</style>

</head>

<body>
	<h1>Candidatos</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<form id="pesquisa" method="post" action="${linkTo[IndexController].pesquisar}">
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
					
					<input type="hidden" name="pagina" id="pagina" value="0"/>
					
					<a id="btPesquisar" role="button" class="btn btn-primary btn-lg">Buscar</a>
					
				</form>
			</div>
			
			<div class="col-md-8" id="painel">
				<div class="candidatos">
					<div class="template row">
						<div class="col-md-2">
							<img width="70%" class="image" />
						</div>
						<div class="field col-md-9">
							<div class="field">
								Nome:<label class="nome"></label><p/>
							</div>
							
							<div class="field">
								Apelido:<label class="apelido"></label><p/>
							</div>
							
							<div class="field">
								Ocupação:<label class="ocupacao"></label><p/>
							</div>
							
							<div class="field-normal">
								Processos:<label class="processos"></label><p/>
							</div>
						</div>
					</div>
				</div>
				
				<ul class="pager">
			  		<li><a href="#" id="prev">Previous</a></li>
			  		<li><a href="#" id="next">Next</a></li>
				</ul>
			</div>
			 		
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
						$('.candidatos').find('.candidato').remove();
						
						if (data.resultado.length > 0) {
							var candidatos = data.resultado;
							$(candidatos).each(function(idx, candidato) {
								var template = $('.template').clone();
								template.removeClass('template');
								template.addClass('candidato');
								template.css('display', 'block');
								template.find('.image').attr('src', candidato.foto);
								template.find('.nome').html(candidato.nome);
								template.find('.apelido').html(candidato.apelido);
								template.find('.ocupacao').html(candidato.ocupacao);
								template.find('.processos').html(candidato.processos);
								
								$('.candidatos').append(template);
							});
						}
					},
					
					statusCode: 
					{
						400: function(data) {
							alert(/.*?<body>(.*?)<\/body>.*/g.exec(data.responseText)[1]);
						}
					}
				});		
			};

			$('#next').click(function(evt) {
				var page = $('#pagina').val();
				$('#pagina').val(parseInt(page, 10) + 1);
				search();
			});

			$('#prev').click(function(evt) {
				var page = $('#pagina').val();
				$('#pagina').val(parseInt(page, 10) - 1);
				search();
			});
			
			$('#btPesquisar').click(function(evt) {
				$('#pagina').val(0);
				search();
			});
			
		});
	</script>
</body>

</html>