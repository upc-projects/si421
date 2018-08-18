package source.open.semana14.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import source.open.semana14.entidades.Movimiento;

@Repository
public interface MovimientoRepositorio extends JpaRepository<Movimiento, Integer> {

}
