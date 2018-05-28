package semana09.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import semana09.entidad.Autor;
import semana09.entidad.Editorial;
import semana09.entidad.Genero;

@Service
public interface IEditorialService {

	public List<Editorial> listado();
	
	public boolean agregar(Editorial obj);
	
	public boolean eliminar(int id);
	
	public Optional<Editorial> buscarPorID(int id);
	
	public boolean actualizar(Editorial obj);
	
}
