package service;

import java.util.List;

import entities.Autor;
import entities.Editorial;
import entities.Libro;

public interface ILibroService {

	public List<Libro> listar();

	public boolean agregar(Libro obj);
	
	public boolean eliminar(int id);
}
