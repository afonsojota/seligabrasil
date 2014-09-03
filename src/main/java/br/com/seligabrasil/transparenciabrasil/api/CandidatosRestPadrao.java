package br.com.seligabrasil.transparenciabrasil.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.com.seligabrasil.infra.RestHTTPClient;
import br.com.seligabrasil.modelo.dominio.Bem;
import br.com.seligabrasil.modelo.dominio.Candidato;
import br.com.seligabrasil.modelo.dominio.Candidatura;
import br.com.seligabrasil.modelo.dominio.Doacao;
import br.com.seligabrasil.modelo.dominio.Estatisticas;
import br.com.seligabrasil.transparenciabrasil.dto.FiltroPesquisaCandidato;
import br.com.seligabrasil.transparenciabrasil.exception.RespostaIncompativel;

import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CandidatosRestPadrao implements CandidatosRest {
	
	private RestHTTPClient http;
	
	@Inject
	public CandidatosRestPadrao(RestHTTPClient http) {
		this.http = http;
	}

	@Override
	public List<Candidato> getLista(FiltroPesquisaCandidato filtro) throws RespostaIncompativel {
		String candidatosJson = getCandidatosJson(filtro);
		
		try { 
			Gson gson = new Gson();
			Candidato[] candidatos = gson.fromJson(candidatosJson, Candidato[].class);
			return Arrays.asList(candidatos);
			
		} catch (JsonSyntaxException e) {
			throw new RespostaIncompativel(e, Optional.of(candidatosJson));
		}
		
	}

	@Override
	public Candidato getCandidato(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bem> getBens(String idCandidato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doacao> getDoacoes(String idCandidato, Integer anoEleitoral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidatura> getCandidaturas(String idCandidato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estatisticas getEstatisticas(String idCandidato) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getCandidatosJson(FiltroPesquisaCandidato filtro) {
		Map<String, String> parametros = filtro.getParametros();

		for (String key : parametros.keySet()) {
			http.addParameter(key, parametros.get(key));
		}
		
		http.addParameter("_offset", filtro.getPagina() * 5);
		http.addParameter("_limit", 5);
		
		return http.get("/candidatos");
	}
}
