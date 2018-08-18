package dao;

import java.util.List;

import entities.Autor;
import entities.Editorial;
import entities.Genero;

public interface IGeneroDAO {

	public List<Genero> listar();
	
	public boolean agregar(Genero obj);
	
	public boolean eliminar(int id);
}
