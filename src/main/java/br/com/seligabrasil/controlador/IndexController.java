package br.com.seligabrasil.controlador;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.seligabrasil.modelo.dominio.Candidato;
import br.com.seligabrasil.modelo.repositorio.Cargos;
import br.com.seligabrasil.modelo.repositorio.Estados;
import br.com.seligabrasil.modelo.repositorio.Partidos;
import br.com.seligabrasil.transparenciabrasil.api.CandidatosRest;
import br.com.seligabrasil.transparenciabrasil.dto.FiltroPesquisaCandidato;

@Controller
public class IndexController {

	@Inject private Cargos cargos;
	
	@Inject private Estados estados;
	
	@Inject private Partidos partidos;
	
	@Inject private CandidatosRest candidatos;
	
	@Inject private Result result;
	
	@Inject private Validator validator;
	
	@Path("/")
	public void index() {
		result.include("cargos", cargos.recuperaLista());
		result.include("estados", estados.recuperaLista());
		result.include("partidos", partidos.recuperaLista());
	}
	
	@Post("/pesquisar")
	public void pesquisar(@Valid FiltroPesquisaCandidato filtro) {
		validator.onErrorSendBadRequest();
		
		List<Candidato> resultado = candidatos.getLista(filtro);
		
		result.use(Results.json()).from(resultado).serialize();
	}
}