package dao.implement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.ILibroDAO;
import entities.Libro;

public class LibroDAO implements ILibroDAO{
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public LibroDAO() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}

	@Override
	public List<Libro> listar() {
		List<Libro> Libroes = new ArrayList<Libro>();
		try {
			TypedQuery<Libro> tq = em.createQuery("select a from Libro a",Libro.class);
			Libroes = tq.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Libroes;
	}

	@Override
	public boolean crearLibro(Libro l) {
		boolean creado = false;
		try {
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			creado = true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
		}
		return creado;
	}

	@Override
	public boolean eliminarLibro(int id) {
		boolean eliminado = false;
		try {
			Libro Libro = em.find(Libro.class, id);
			em.getTransaction().begin();
			em.remove(Libro);
			em.getTransaction().commit();
			eliminado = true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
		}
		return eliminado;
	}

}
