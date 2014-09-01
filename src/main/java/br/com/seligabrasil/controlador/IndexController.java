package br.com.seligabrasil.controlador;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.seligabrasil.modelo.repositorio.Cargos;
import br.com.seligabrasil.modelo.repositorio.Estados;
import br.com.seligabrasil.modelo.repositorio.Partidos;

@Controller
public class IndexController {

	private final Cargos cargos;
	private final Estados estados;
	private final Partidos partidos;
	
	private final Result result;

	@Deprecated // CDI-eyes only
	IndexController() {
		this(null, null, null, null);
	}
	
	@Inject
	public IndexController(Cargos cargos, Estados estados, Partidos partidos,
			Result result) {
		this.cargos = cargos;
		this.estados = estados;
		this.partidos = partidos;
		this.result = result;
	}

	@Path("/")
	public void index() {
		result.include("cargos", cargos.recuperaLista());
		result.include("estados", estados.recuperaLista());
		result.include("partidos", partidos.recuperaLista());
	}
}