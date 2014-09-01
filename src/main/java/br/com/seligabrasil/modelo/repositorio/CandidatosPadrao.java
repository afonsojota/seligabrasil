package br.com.seligabrasil.modelo.repositorio;

import java.util.List;

import br.com.seligabrasil.infra.RestHTTPClient;
import br.com.seligabrasil.modelo.dominio.Candidato;
import br.com.seligabrasil.transparenciabrasil.dto.FiltroPesquisaCandidato;

public class CandidatosPadrao implements Candidatos {

	private RestHTTPClient rest;
	
	@Override
	public List<Candidato> pesquisar(FiltroPesquisaCandidato filtro) {
		
		rest.get("");
		
		return null;
	}

}
