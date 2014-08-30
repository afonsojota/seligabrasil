package br.com.seligabrasil.observers;

import java.util.List;

import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.seligabrasil.modelo.dominio.Estado;
import br.com.seligabrasil.modelo.repositorio.Estados;
import br.com.seligabrasil.modelo.transparenciabrasil.api.EstadosRest;

public class ApplicationInitializer {

	public void carregarDadosBasicos(
		EstadosRest estadosRest,
		Estados estados,
		@Observes VRaptorInitialized init) {

		carregaOsEstadosBrasileiros(estadosRest, estados);
	}

	private void carregaOsEstadosBrasileiros(EstadosRest estadosRest, Estados estados) {
		List<Estado> listaDeEstados = estados.recuperaLista();
		
		if (listaDeEstados.size() == 0) {
			List<Estado> novaLista = estadosRest.getEstados();
			estados.armazena(novaLista);
		}
	}
	
}
