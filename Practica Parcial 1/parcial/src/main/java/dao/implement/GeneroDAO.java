package dao.implement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.IGeneroDAO;
import entities.Genero;

public class GeneroDAO implements IGeneroDAO{
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public GeneroDAO() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}

	@Override
	public List<Genero> listar() {
		List<Genero> Generoes = new ArrayList<Genero>();
		try {
			TypedQuery<Genero> tq = em.createQuery("select a from Genero a",Genero.class);
			Generoes = tq.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Generoes;
	}

	@Override
	public boolean crearGenero(Genero l) {
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
	public boolean eliminarGenero(int id) {
		boolean eliminado = false;
		try {
			Genero Genero = em.find(Genero.class, id);
			em.getTransaction().begin();
			em.remove(Genero);
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
