package dao.implement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.IEditorialDAO;
import entities.Editorial;

public class EditorialDAO implements IEditorialDAO{
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public EditorialDAO() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}

	@Override
	public List<Editorial> listar() {
		List<Editorial> Editoriales = new ArrayList<Editorial>();
		try {
			TypedQuery<Editorial> tq = em.createQuery("select a from Editorial a",Editorial.class);
			Editoriales = tq.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Editoriales;
	}

	@Override
	public boolean crearEditorial(Editorial l) {
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
	public boolean eliminarEditorial(int id) {
		boolean eliminado = false;
		try {
			Editorial Editorial = em.find(Editorial.class, id);
			em.getTransaction().begin();
			em.remove(Editorial);
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
