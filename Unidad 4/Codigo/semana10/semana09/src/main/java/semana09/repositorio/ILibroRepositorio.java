package semana09.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import semana09.entidad.Autor;
import semana09.entidad.Libro;

@Repository
public interface ILibroRepositorio extends JpaRepository<Libro, Integer> {

}
