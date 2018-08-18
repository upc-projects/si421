package source.open.semana14.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import source.open.semana14.entidades.Cuenta;
import source.open.semana14.entidades.Movimiento;
import source.open.semana14.repositorios.CuentaRepositorio;

@Service
public class CuentaServiceImpl implements CuentaService {
	@Autowired
	CuentaRepositorio repo;
	
	@Override
	public List<Cuenta> listado() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean validarSaldo(Movimiento objMov) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			if(objMov.getTipo() == 0) { // Si es retiro, validar que el monto a retirar sea menor que el saldo de la cuenta
				Optional<Cuenta> objCuenta = repo.findById(objMov.getCuenta().getId());
				if(objCuenta.isPresent()) {
					if(objMov.getCantidad()>objCuenta.get().getSaldo()) {
						flag = false;
					}
				}else {
					flag = false;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

}
