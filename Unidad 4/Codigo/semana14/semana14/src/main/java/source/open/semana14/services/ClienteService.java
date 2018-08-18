package source.open.semana14.services;

import java.util.List;

import org.springframework.stereotype.Service;

import source.open.semana14.entidades.Cliente;

@Service
public interface ClienteService {

	public List<Cliente> listado();
}
