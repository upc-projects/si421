package dao.implement;

import java.sql.Connection;
import java.util.List;

import dao.Conexion;
import dao.InterfaceVentas;
import entities.Venta;

public class ImplVenta implements InterfaceVentas {

	@Override
	public boolean registrarVenta(Venta v) {
		boolean flag = false;
		try {
			Connection con = Conexion.conectar();
			String query = "insert into Ventas"+
							" (idVenta,Producto,)";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean eliminarVenta(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVenta(Venta v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Venta> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta buscarVenta(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
