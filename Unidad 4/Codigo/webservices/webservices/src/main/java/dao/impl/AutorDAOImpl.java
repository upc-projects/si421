package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.IAutorDAO;
import entities.Autor;

public class AutorDAOImpl implements IAutorDAO {
	EntityManagerFactory emf;
	EntityManager em;
	
	public AutorDAOImpl() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}

	@Override
	public List<Autor> listar() {
		List<Autor> listado = null;
		try {
			TypedQuery<Autor> tq = em.createQuery("select a from Autor a", Autor.class);
			listado = tq.getResultList();			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(emf.isOpen()) {
				em.close();
				emf.close();
				
			}
		}
	
		return listado;
	}

	@Override
	public boolean registrar(Autor obj) {
		boolean flag = false;
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}finally {
			if(emf.isOpen()) {
				em.close();
				emf.close();				
			}
		}
		
		return flag;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Autor obj =em.find(Autor.class, id);
			
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}finally {
			if(emf.isOpen()) {
				em.close();
				emf.close();				
			}
		}
		
		return flag;
	}

}
