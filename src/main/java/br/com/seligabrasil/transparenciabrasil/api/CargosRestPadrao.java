package br.com.seligabrasil.transparenciabrasil.api;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import br.com.seligabrasil.infra.RestHTTPClient;
import br.com.seligabrasil.modelo.dominio.Cargo;

import com.google.gson.Gson;

public class CargosRestPadrao implements CargosRest {

	@Inject
	private RestHTTPClient rest;
	
	@Override
	public List<Cargo> getCargos() {
		String cargosJson = rest.get("/sandbox/v1/cargos");
		
		Gson gson = new Gson();
		Cargo[] cargos = gson.fromJson(cargosJson, Cargo[].class);
		
		return Arrays.asList(cargos);
	}

}
