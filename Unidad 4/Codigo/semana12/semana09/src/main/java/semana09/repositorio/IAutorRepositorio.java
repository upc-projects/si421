package semana09.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import semana09.entidad.Autor;

@Repository
public interface IAutorRepositorio extends JpaRepository<Autor, Integer> {

}
