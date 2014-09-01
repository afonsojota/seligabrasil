package br.com.seligabrasil.infra.dao.jpa;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.seligabrasil.infra.dao.PartidoDAO;
import br.com.seligabrasil.modelo.dominio.Partido;

public class PartidoDaoJPA implements PartidoDAO {

	private EntityManager manager;

	@Inject
	public PartidoDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Partido> lista() {
		return manager.createQuery(
			"select p from Partido p", Partido.class)
			.getResultList();
	}

	@Override
	public void salvar(Partido partido) {
		manager.persist(partido);
	}

}
