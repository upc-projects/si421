package dao.implement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.IAutorDAO;
import entities.Autor;

public class AutorDAO implements IAutorDAO{
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	public AutorDAO() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}

	@Override
	public List<Autor> listar() {
		List<Autor> autores = new ArrayList<Autor>();
		try {
			TypedQuery<Autor> tq = em.createQuery("select a from Autor a",Autor.class);
			autores = tq.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return autores;
	}

	@Override
	public boolean crearAutor(Autor l) {
		
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
	public boolean eliminarAutor(int id) {
		boolean eliminado = false;
		try {
			Autor autor = em.find(Autor.class, id);
			em.getTransaction().begin();
			em.remove(autor);
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
