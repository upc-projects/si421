package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.IEditorialDAO;
import entities.Editorial;

public class EditorialDAOImpl implements IEditorialDAO {

	EntityManagerFactory emf;
	EntityManager em;
	
	public EditorialDAOImpl() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Editorial> listar() {
		List<Editorial> listado = new ArrayList<Editorial>();
		
		try {
			TypedQuery<Editorial> tq = 
							em.createQuery("select a from Editorial a", Editorial.class);
			listado = tq.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}			
		
		return listado;
	}

	@Override
	public boolean agregar(Editorial obj) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
		}		
		
		return flag;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Editorial obj = em.find(Editorial.class, id);
			
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			
			flag = true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

}
