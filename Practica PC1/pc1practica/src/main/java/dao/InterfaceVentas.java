package dao;

import java.util.List;

import entities.Venta;

public interface InterfaceVentas {
	public boolean registrarVenta(Venta v);
	public boolean eliminarVenta(int id);
	public boolean updateVenta(Venta v);
	public List<Venta> listar();
	public Venta buscarVenta(int id);
}
