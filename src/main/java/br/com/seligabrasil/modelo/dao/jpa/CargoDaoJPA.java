package br.com.seligabrasil.modelo.dao.jpa;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.seligabrasil.modelo.dao.CargoDao;
import br.com.seligabrasil.modelo.dominio.Cargo;

public class CargoDaoJPA implements CargoDao {

	@Inject
	private EntityManager manager;
	
	@Override
	public List<Cargo> lista() {
		return manager.createQuery(
			"select c from Cargo c", Cargo.class)
			.getResultList();
	}

	@Override
	public void salvar(Cargo cargo) {
		manager.persist(cargo);
	}

}
