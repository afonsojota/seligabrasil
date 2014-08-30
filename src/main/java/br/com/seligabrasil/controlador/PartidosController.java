package br.com.seligabrasil.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.seligabrasil.modelo.Partidos;
import br.com.seligabrasil.modelo.dominio.Casa;
import br.com.seligabrasil.modelo.dominio.CasaOpcoes;

@Controller
public class PartidosController {

	private Partidos repositorio;
	private Result result;
	
	@Inject
	public PartidosController(
		Result result, 
		Partidos repositorio) {
		
		this.result = result;
		this.repositorio = repositorio;
	}
	
	@Get("/partidos")
	public void lista() {
		result.include("partidos", repositorio.getPartidos());
	}
	
	@Get("/partidos/estatisticas")
	public void formulario() {
		List<Casa> casas = new ArrayList<>();
		for (CasaOpcoes casa : CasaOpcoes.values()) {
			casas.add(new Casa(casa.getCodigo(), casa.getDescricao()));
		}
		
		result.include("casas", casas);
	}
	
	@Post("/partidos/estatisticas")
	public void estatisticas(String estado, String casa) {
//		List<PartidoJson> partidos = estatisticas.calcularEstatisticas(
//			estado, CasaOpcoes.getPorCodigo(Integer.valueOf(casa)));
//		
//		result.include("partidos", partidos);
//		result.of(this).lista();
	}
}
