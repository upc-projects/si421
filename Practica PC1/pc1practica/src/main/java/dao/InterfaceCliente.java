package dao;

import java.util.List;

import entities.Cliente;

public interface InterfaceCliente {
	public List<Cliente> listar();
	public Cliente buscarPorID(int id);
	public boolean eliminar(int id);
	public boolean createCliente(Cliente c);
	public boolean updateCliente(Cliente c);
}
