package br.com.seligabrasil.produtor;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAProducer {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Produces
	public EntityManager createEntityManager() {
		return manager;
	}
	
}
