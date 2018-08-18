package source.open.semana14.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import source.open.semana14.entidades.Cuenta;
import source.open.semana14.entidades.Movimiento;
import source.open.semana14.repositorios.CuentaRepositorio;
import source.open.semana14.repositorios.MovimientoRepositorio;

@Service
public class MovimientoServiceImpl implements MovimientoService {
	@Autowired
	MovimientoRepositorio repo;
	@Autowired
	CuentaRepositorio repoCuenta;
	
	@Override
	public boolean registrar(Movimiento objMov) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		try {
			Movimiento mov = repo.save(objMov);
			if(mov != null) {
				Optional<Cuenta> objCuenta = repoCuenta.findById(objMov.getCuenta().getId());
				if(objCuenta.isPresent()){
					double nuevoSaldo;
					if(mov.getTipo()==0) { //si es retiro, restar saldo
						nuevoSaldo = objCuenta.get().getSaldo();
						nuevoSaldo = nuevoSaldo - objMov.getCantidad();
					}else { //si es deposito, sumar saldo
						nuevoSaldo = objCuenta.get().getSaldo();
						nuevoSaldo = nuevoSaldo + objMov.getCantidad();
					}
					//actualiza saldo de la cuenta
					objCuenta.get().setSaldo(nuevoSaldo);
					repoCuenta.save(objCuenta.get());
				}
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return flag;
	}

}
