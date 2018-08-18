package dao;

import java.util.List;

import entities.Autor;
import entities.Editorial;
import entities.Genero;
import entities.Libro;

public interface ILibroDAO {

	public List<Libro> listar();
	
	public boolean agregar(Libro obj);
	
	public boolean eliminar(int id);
}
