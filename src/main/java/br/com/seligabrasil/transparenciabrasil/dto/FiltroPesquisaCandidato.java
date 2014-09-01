package br.com.seligabrasil.transparenciabrasil.dto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

public class FiltroPesquisaCandidato {
	
	@NotNull
	private String estado;
	
	private String partido;
	
	private String cargo;
	
	private String nomeCandidato;

	public FiltroPesquisaCandidato(HttpServletRequest request) {
		
		estado = request.getParameter("estado");
		partido = request.getParameter("partido");
		cargo = request.getParameter("cargo");
		nomeCandidato = request.getParameter("nomeCandidato");
	
	}

	public String getEstado() {
		return estado;
	}

	public String getPartido() {
		return partido;
	}

	public String getCargo() {
		return cargo;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}
	
}
