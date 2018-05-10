package dao;

import java.util.List;

import entities.Genero;

public interface IGeneroDAO {
	public List<Genero> listar();
	public boolean crearGenero(Genero l);
	public boolean eliminarGenero(int id);
}
