package service;

import java.util.List;

import entities.Editorial;

public interface IEditorialService {
	
	public List<Editorial> listar();
	public boolean crearEditorial(Editorial l);
	public boolean eliminarEditorial(int id);

}
