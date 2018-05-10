package dao;

import java.util.List;

import entities.Editorial;

public interface IEditorialDAO {
	
	public List<Editorial> listar();
	public boolean crearEditorial(Editorial l);
	public boolean eliminarEditorial(int id);

}
