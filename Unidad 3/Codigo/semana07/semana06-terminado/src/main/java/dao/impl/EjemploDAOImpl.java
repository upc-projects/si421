package dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IEjemploDAO;

public class EjemploDAOImpl implements IEjemploDAO {
	EntityManagerFactory emf;
	EntityManager em;
	
	public EjemploDAOImpl() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}

}
