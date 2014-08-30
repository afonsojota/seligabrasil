package br.com.seligabrasil.modelo.transparenciabrasil.model;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import com.google.gson.Gson;

import br.com.seligabrasil.modelo.RestHTTPClient;
import br.com.seligabrasil.modelo.dominio.Estado;
import br.com.seligabrasil.modelo.transparenciabrasil.api.EstadosRest;

public class EstadosRestPadrao implements EstadosRest {

	private RestHTTPClient rest;
	
	@Inject
	public EstadosRestPadrao(RestHTTPClient rest) {
		this.rest = rest;
	}

	@Override
	public List<Estado> getEstados() {
		String estados = rest
				.get("/sandbox/v1/estados");
		
		Gson gson = new Gson();
		Estado[] arrayEstados = gson.fromJson(estados, Estado[].class);
		
		return Arrays.asList(arrayEstados);
	}

}
