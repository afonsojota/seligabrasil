package br.com.seligabrasil.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.seligabrasil.modelo.dominio.Candidato;
import br.com.seligabrasil.modelo.repositorio.Candidatos;
import br.com.seligabrasil.modelo.repositorio.Cargos;
import br.com.seligabrasil.modelo.repositorio.Estados;
import br.com.seligabrasil.modelo.repositorio.Partidos;
import br.com.seligabrasil.transparenciabrasil.dto.PesquisaCandidato;
import br.com.seligabrasil.transparenciabrasil.dto.PesquisaCandidato.Builder;

import com.google.common.base.Strings;

@Controller
public class IndexController {

	private final Cargos cargos;
	private final Estados estados;
	private final Partidos partidos;
	private final Candidatos candidatos;
	
	private final Result result;

	@Deprecated // CDI-eyes only
	IndexController() {
		this(null, null, null, null, null);
	}
	
	@Inject
	public IndexController(Cargos cargos, Estados estados, Partidos partidos,
			Candidatos candidatos, Result result) {
		this.cargos = cargos;
		this.estados = estados;
		this.partidos = partidos;
		this.candidatos = candidatos;
		this.result = result;
	}

	@Path("/")
	public void index() {
		result.include("cargos", cargos.recuperaLista());
		result.include("estados", estados.recuperaLista());
		result.include("partidos", partidos.recuperaLista());
	}
	
	@Post("/pesquisar")
	public void pesquisar(String estado, String partido, String cargo, String nomeCandidato) {
		Builder builderPesquisa = new PesquisaCandidato.Builder(estado);
		
		if (!Strings.isNullOrEmpty(partido)) {
			builderPesquisa.partido(partido);
		}
		
		if (!Strings.isNullOrEmpty(cargo)) {
			builderPesquisa.cargo(cargo);
		}
		
		if (!Strings.isNullOrEmpty(nomeCandidato)) {
			builderPesquisa.nomeCandidato(nomeCandidato);
		}
		
		List<Candidato> resultado = candidatos.pesquisar(builderPesquisa.build());
		
		result.of(Results.json()).from(resultado).serialize();
	}
}