package dao.implement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.ILibritoDAO;
import entities.Librito;

public class LibritoDAO implements ILibritoDAO{
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	public LibritoDAO() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}

	@Override
	public List<Librito> listar() {
		List<Librito> libritos = new ArrayList<Librito>();
		try {
			TypedQuery<Librito> query = em.createQuery("select a from Librito a",Librito.class);
			libritos = query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return libritos;
	}

	@Override
	public boolean crearLibrito(Librito l) {
		boolean flag = false;
		try {
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean eliminarLibrito(int id) {
		boolean flag = false;
		try {
			Librito l = em.find(Librito.class, id);
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public Librito listarISBN(String isbn) {
		Librito l = null;
		try {
			TypedQuery<Librito> query = em.createQuery("select a from Librito a where a.isbn=" + isbn, Librito.class);
			l = query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return l;
	}



}
