package source.open.pc02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import source.open.pc02.entidades.Sede;

@Service
public interface SedeService {

	public List<Sede> listar();
}
