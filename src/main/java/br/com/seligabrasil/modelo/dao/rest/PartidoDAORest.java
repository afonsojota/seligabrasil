package br.com.seligabrasil.modelo.dao.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.seligabrasil.modelo.RestHTTPClient;
import br.com.seligabrasil.modelo.dao.PartidoDAO;
import br.com.seligabrasil.modelo.dominio.Partido;
import br.com.seligabrasil.modelo.dto.PartidoJson;

import com.google.gson.Gson;

public class PartidoDAORest implements PartidoDAO {

	private RestHTTPClient rest;
	
	private EntityManager manager;
	
	@Inject 
	public PartidoDAORest(
			RestHTTPClient rest, 
			EntityManager manager) {
		
		this.rest = rest;
		this.manager = manager;
	}
	
	@Deprecated
	public PartidoDAORest() {
	}
	
	@Override
	public List<Partido> getPartidosDoBD() {
		List<Partido> partidosDB = manager.createQuery(
				"select p from Partido p", Partido.class).getResultList();
		return partidosDB;
	}

	@Override
	public PartidoJson[] getPartidosDoREST() {
		String partidos = rest.get("/sandbox/v1/partidos");
		Gson gson = new Gson();
		return gson.fromJson(partidos, PartidoJson[].class);
	}

	@Override
	public void salvar(Partido partido) {
		manager.persist(partido);
	}

}
