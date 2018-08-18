package service;

import java.util.List;

import entities.Autor;
import entities.Editorial;
import entities.Genero;

public interface IGeneroService {

	public List<Genero> listar();

	public boolean agregar(Genero obj);
	
	public boolean eliminar(int id);
}
