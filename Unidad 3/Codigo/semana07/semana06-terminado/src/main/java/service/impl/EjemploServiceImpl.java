package service.impl;

import dao.IEjemploDAO;
import dao.impl.EjemploDAOImpl;
import service.IEjemploService;

public class EjemploServiceImpl implements IEjemploService {
	IEjemploDAO dao = null;
	
	public EjemploServiceImpl() {
		dao = new EjemploDAOImpl();
	}

	
}
