package semana09.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import semana09.entidad.Autor;
import semana09.entidad.Libro;

@Repository
public interface ILibroRepositorio extends JpaRepository<Libro, Integer> {

	public List<Libro> buscarPorGenero(int genero);
	
	public List<Libro> buscarPorEditorial(int editorial);
	
	public List<Libro> buscarPorPrecio(double precio);
}
