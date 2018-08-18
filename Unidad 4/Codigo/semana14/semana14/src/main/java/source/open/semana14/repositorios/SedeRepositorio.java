package source.open.semana14.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import source.open.semana14.entidades.Sede;

@Repository
public interface SedeRepositorio extends JpaRepository<Sede, Integer> {

}
