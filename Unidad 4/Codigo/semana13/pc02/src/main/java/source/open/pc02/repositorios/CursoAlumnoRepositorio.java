package source.open.pc02.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import source.open.pc02.entidades.CursoAlumno;

@Repository
public interface CursoAlumnoRepositorio
			extends JpaRepository<CursoAlumno, Integer>{

}
