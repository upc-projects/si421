package semana09.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import semana09.entidad.Administrador;
import semana09.entidad.Autor;
import semana09.entidad.Genero;
import semana09.entidad.Libro;

@Service
public interface IAdministradorService {

	public Administrador buscarPorCorreo(String correo);
}
