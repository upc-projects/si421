package service;

import java.util.List;

import entities.Autor;
import entities.Editorial;

public interface IEditorialService {

	public List<Editorial> listar();

	public boolean agregar(Editorial obj);
	
	public boolean eliminar(int id);
}
