package dao.implement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.IProfesorDAO;
import entities.Profesor;

public class ProfesorDAO implements IProfesorDAO{
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	public ProfesorDAO() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}

	@Override
	public List<Profesor> listar() {
		List<Profesor> profesores = new ArrayList<Profesor>();
		try {
			TypedQuery<Profesor> query = em.createQuery("select a from Profesor a",Profesor.class);
			profesores = query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return profesores;
	}

	@Override
	public boolean crearProfe(Profesor p) {
		boolean flag = false;
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean eliminarProfe(int id) {
		boolean flag = false;
		try {
			Profesor p = em.find(Profesor.class, id);
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public Profesor buscarCodigo(String cod) {
		Profesor p = null;
		try {
			TypedQuery<Profesor> query = em.createQuery("select a from Profesor a where a.codigo = " + cod, Profesor.class);
			p = query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}

}
