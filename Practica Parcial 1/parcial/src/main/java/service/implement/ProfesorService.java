package service.implement;

import java.util.List;

import dao.IProfesorDAO;
import dao.implement.ProfesorDAO;
import entities.Profesor;
import service.IProfesorService;

public class ProfesorService implements IProfesorService{
	
	IProfesorDAO profesor;
	
	public ProfesorService() {
		profesor = new ProfesorDAO();
	}

	@Override
	public List<Profesor> listar() {
		return profesor.listar();
	}

	@Override
	public boolean crearProfe(Profesor p) {
		return profesor.crearProfe(p);
	}

	@Override
	public boolean eliminarProfe(int id) {
		
		return profesor.eliminarProfe(id);
	}

	@Override
	public Profesor buscarCodigo(String cod) {
	
		return profesor.buscarCodigo(cod);
	}

}
