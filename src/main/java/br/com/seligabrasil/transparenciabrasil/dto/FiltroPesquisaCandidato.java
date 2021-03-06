package br.com.seligabrasil.transparenciabrasil.dto;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

public class FiltroPesquisaCandidato {
	
	@NotNull
	private String estado;
	
	private String partido;
	
	private String cargo;
	
	private String nomeCandidato;

	private int pagina;
	
	public FiltroPesquisaCandidato(HttpServletRequest request) {
		
		estado = request.getParameter("estado");
		partido = request.getParameter("partido");
		cargo = request.getParameter("cargo");
		nomeCandidato = request.getParameter("nomeCandidato");
		
		String tempPagina = Optional.fromNullable(request.getParameter("pagina")).or("1");
		
		try {
			pagina = Integer.parseInt(tempPagina);
		} catch (NumberFormatException e) {
			pagina = 1;
		}
		
		if ("0".equals(partido)) {
			partido = null;
		}
		
		if ("0".equals(cargo)) {
			cargo = null;
		}
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

	public int getPagina() {
		return pagina;
	}
	
	public Map<String, String> getParametros() {
		Map<String, String> parametros = new HashMap<>();
		
		parametros.put("estado", estado);
		
		if (!Strings.isNullOrEmpty(cargo)) {
			parametros.put("cargo", cargo);
		}
		
		if (!Strings.isNullOrEmpty(partido)) {
			parametros.put("partido", partido);
		}
		
		if (!Strings.isNullOrEmpty(nomeCandidato)) {
			parametros.put("nome", nomeCandidato);
		}
		
		return parametros;
	}
	
}
