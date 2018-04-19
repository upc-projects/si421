package controller;

import dao.InterfaceCliente;
import dao.implement.ImplCliente;
import entities.Cliente;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceCliente cliente = new ImplCliente();
		Cliente c = new Cliente();
		c.setId(6);
		c.setNombre("Enzito");
		c.setApellido("Lizamon");
		//cliente.createCliente(c);
		
		//cliente.eliminar(5);
		
		cliente.updateCliente(c);
	}

}
