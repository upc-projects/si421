package source.open.semana14.services;

import java.util.List;

import org.springframework.stereotype.Service;

import source.open.semana14.entidades.Cuenta;
import source.open.semana14.entidades.Movimiento;

@Service
public interface CuentaService {
	
	public List<Cuenta> listado();
	
	public boolean validarSaldo(Movimiento objMov);
}
