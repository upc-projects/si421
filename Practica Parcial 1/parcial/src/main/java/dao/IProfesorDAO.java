package dao;

import java.util.List;

import entities.Profesor;

public interface IProfesorDAO {
	public List<Profesor> listar();
	public boolean  crearProfe(Profesor p);
	public boolean eliminarProfe(int id);
	public Profesor buscarCodigo(String cod);
}
