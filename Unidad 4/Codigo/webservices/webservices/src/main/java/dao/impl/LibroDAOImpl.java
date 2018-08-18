package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.ILibroDAO;
import entities.Libro;

public class LibroDAOImpl implements ILibroDAO {
	EntityManagerFactory emf;
	EntityManager em;
	
	public LibroDAOImpl() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}

	@Override
	public List<Libro> listar() {
		List<Libro> listado = null;
		try {
			TypedQuery<Libro> tq = em.createQuery("select a from Libro a", Libro.class);
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
	public boolean registrar(Libro obj) {
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
			Libro obj =em.find(Libro.class, id);
			
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
