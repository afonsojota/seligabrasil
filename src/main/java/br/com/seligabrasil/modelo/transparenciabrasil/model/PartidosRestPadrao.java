package br.com.seligabrasil.modelo.transparenciabrasil.model;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import br.com.seligabrasil.modelo.RestHTTPClient;
import br.com.seligabrasil.modelo.dominio.Partido;
import br.com.seligabrasil.modelo.transparenciabrasil.api.PartidosRest;

import com.google.gson.Gson;

public class PartidosRestPadrao implements PartidosRest {

	private RestHTTPClient rest;
	
	@Inject
	public PartidosRestPadrao(RestHTTPClient rest) {
		this.rest = rest;
	}

	@Override
	public List<Partido> getPartidos() {
		String json = rest.get("/sandbox/v1/partidos");
		
		Gson gson = new Gson();
		Partido[] partidosFromJson = gson.fromJson(json, Partido[].class);
		
		return Arrays.asList(partidosFromJson); 
	}

}
