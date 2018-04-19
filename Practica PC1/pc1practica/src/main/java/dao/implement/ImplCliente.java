package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.Conexion;
import dao.InterfaceCliente;
import entities.Cliente;

public class ImplCliente implements InterfaceCliente{

	@Override
	public List<Cliente> listar() {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		try {
			Connection con = Conexion.conectar();
			Statement stm = con.createStatement();
			ResultSet rst = stm.executeQuery("select * from Cliente");
			
			Cliente cliente = null;
			
			while(rst.next()) {
				cliente = new Cliente();
				cliente.setId(rst.getInt("idCliente"));
				cliente.setNombre(rst.getString("NombreCliente"));
				cliente.setApellido(rst.getString("ApellidoCliente"));
				
				listaCliente.add(cliente);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return listaCliente;
		
	}

	@Override
	public Cliente buscarPorID(int id) {
		Cliente cliente = new Cliente();
		try {
			Connection con = Conexion.conectar();
			Statement stm = con.createStatement();
			ResultSet rst = stm.executeQuery("select * from Cliente where idCliente = "+id);
			
			if(rst != null) {
				cliente.setId(rst.getInt("idCliente"));
				cliente.setNombre(rst.getString("NombreCliente"));
				cliente.setApellido(rst.getString("ApellidoCliente"));
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cliente;
	}

	@Override
	public boolean eliminar(int id) {
		boolean flag = false;
		try {
			Connection con = Conexion.conectar();
			PreparedStatement smt = con.prepareStatement("delete from Cliente where idCliente = "+id);
			
			int filas = smt.executeUpdate();
			Conexion.cerrar(con);
			
			if(filas == 1) {
				flag = true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean createCliente(Cliente c) {
		boolean f = false;
		try {
			Connection con = Conexion.conectar();
			String query = "insert into Cliente"
							+ " (NombreCliente,ApellidoCliente)"
							+ " values(?,?)";
			
			PreparedStatement smt = con.prepareStatement(query);
			smt.setString(1, c.getNombre());
			smt.setString(2, c.getApellido());
			
			int filas = smt.executeUpdate();
			Conexion.cerrar(con);
			
			if (filas == 1) {
				f = true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return f;
		
	}

	@Override
	public boolean updateCliente(Cliente c) {
		boolean flag = false;
		Cliente cliente = new Cliente();
		try {
			Connection con = Conexion.conectar();
			String query = "update Cliente set NombreCliente= '"+c.getNombre() + "' , ApellidoCliente= '"+c.getApellido() + "' where idCliente= "+c.getId();
			PreparedStatement smt = con.prepareStatement(query);
			int filas = smt.executeUpdate();
			if(filas == 1) {
				flag = true;
			}
			Conexion.cerrar(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
}
