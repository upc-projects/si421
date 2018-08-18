package source.open.semana14.services;

import org.springframework.stereotype.Service;

import source.open.semana14.entidades.Movimiento;

@Service
public interface MovimientoService {

	public boolean registrar (Movimiento obj);
}
