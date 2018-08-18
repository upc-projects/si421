package semana09.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import semana09.entidad.Administrador;
import semana09.entidad.Autor;
import semana09.entidad.Rol;

@Repository
public interface IAdministradorRepositorio 
			extends JpaRepository<Administrador, Integer> {

	public Administrador buscarPorCorreo(String correo);
}
