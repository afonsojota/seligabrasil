package br.com.seligabrasil.transparenciabrasil.dto;

import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;

public class FabricaDeFiltroPesquisaCandidato {

	@Produces
	public FiltroPesquisaCandidato preparaFiltrosDaPesquisa(HttpServletRequest request) {
		
		FiltroPesquisaCandidato filtro = new FiltroPesquisaCandidato(request);
		return filtro;
		
	}
}
