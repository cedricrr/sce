package br.com.sistemaEventos.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
//	@PersistenceContext
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}

