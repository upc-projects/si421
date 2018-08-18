package semana09.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import semana09.entidad.Autor;
import semana09.entidad.Genero;

@Service
public interface IGeneroService {

	public List<Genero> listado();
	
	public boolean agregar(Genero obj);
	
	public boolean eliminar(int id);
	
	public Optional<Genero> buscarPorID(int id);
	
	public boolean actualizar(Genero obj);
	
}
