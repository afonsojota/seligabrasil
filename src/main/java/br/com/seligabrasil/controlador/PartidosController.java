package br.com.seligabrasil.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.seligabrasil.modelo.dominio.Casa;
import br.com.seligabrasil.modelo.dominio.CasaOpcoes;
import br.com.seligabrasil.modelo.repositorio.Partidos;

@Controller
public class PartidosController {

	private Partidos partidos;
	private Result result;
	
	@Inject
	public PartidosController(
		Result result, 
		Partidos repositorio) {
		
		this.result = result;
		this.partidos = repositorio;
	}
	
	@Get("/partidos")
	public void lista() {
		result.include("partidos", partidos.recuperaLista());
	}
	
	@Get("/partidos/estatisticas")
	public void formulario() {
		List<Casa> casas = new ArrayList<>();
		for (CasaOpcoes casa : CasaOpcoes.values()) {
			casas.add(new Casa(casa.getCodigo(), casa.getDescricao()));
		}
		
		result.include("casas", casas);
	}
	
}
