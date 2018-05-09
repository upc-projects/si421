package service;

import java.util.List;

import entities.Genero;

public interface IGeneroService {
	
	public List<Genero> listar();
	public boolean crearGenero(Genero l);
	public boolean eliminarGenero(int id);

}
