package br.com.seligabrasil.observers;

import java.util.List;

import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.seligabrasil.modelo.dominio.Estado;
import br.com.seligabrasil.modelo.dominio.Partido;
import br.com.seligabrasil.modelo.repositorio.Estados;
import br.com.seligabrasil.modelo.repositorio.Partidos;
import br.com.seligabrasil.modelo.transparenciabrasil.api.EstadosRest;
import br.com.seligabrasil.modelo.transparenciabrasil.api.PartidosRest;

public class ApplicationInitializer {

	public void carregarDadosBasicos(
		EstadosRest estadosRest,
		PartidosRest partidosRest,
		Estados estados,
		Partidos partidos,
		@Observes VRaptorInitialized init) {

		carregaOsEstadosBrasileiros(estadosRest, estados);
		carregaOsPartidos(partidosRest, partidos);
	}

	private void carregaOsPartidos(PartidosRest partidosRest, Partidos partidos) {
		List<Partido> listaDePartidos = partidos.recuperaLista();
		
		if (listaDePartidos.size() == 0) {
			List<Partido> novaLista = partidosRest.getPartidos();
			partidos.armazena(novaLista);
		}
	}
	
	private void carregaOsEstadosBrasileiros(EstadosRest estadosRest, Estados estados) {
		List<Estado> listaDeEstados = estados.recuperaLista();
		
		if (listaDeEstados.size() == 0) {
			List<Estado> novaLista = estadosRest.getEstados();
			estados.armazena(novaLista);
		}
	}
	
}
