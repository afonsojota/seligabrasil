package br.com.seligabrasil.infra.dao.jpa;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.seligabrasil.infra.dao.EstadoDAO;
import br.com.seligabrasil.modelo.dominio.Estado;

public class EstadoDaoJPA implements EstadoDAO {

	private EntityManager manager;
	
	@Inject
	public EstadoDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Estado> lista() {
		return manager.createQuery(
			"select e from Estado e", Estado.class).getResultList();
	}

	@Override
	public Long insere(Estado estado) {
		manager.persist(estado);
		return estado.getId();
	}

}
