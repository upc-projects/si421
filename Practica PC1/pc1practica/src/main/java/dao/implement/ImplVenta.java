package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
			String query = "insert into Ventas"
							+ " (Producto,Cantidad,Precio,Subtotal,Descuento,Neto,idCliente)"
							+ " values(?,?,?,?,?,?,?)";
			PreparedStatement smt = con.prepareStatement(query);
			smt.setString(1, v.getProducto());
			smt.setInt(2, v.getCantidad());
			smt.setDouble(3, v.getPrecio());
			smt.setDouble(4, v.getSubtotal());
			smt.setDouble(5, v.getDescuento());
			smt.setDouble(6, v.getNeto());
			smt.setInt(7, v.getIdCliente());
			int filas = smt.executeUpdate();
			con.close();
			
			if(filas == 1) {
				flag = true;
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean eliminarVenta(int id) {
		boolean flag = false;
		try {
			Connection c = Conexion.conectar();
			String query = "delete from Venta where idVenta = "+id;
			PreparedStatement stm = c.prepareStatement(query);
			int filas = stm.executeUpdate();
			c.close();
			if(filas == 1) {
				flag = true;
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean updateVenta(Venta v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Venta> listar() {
		List<Venta> lventa = new ArrayList<Venta>();
		try {
			Connection con = Conexion.conectar();
			Statement stm = con.createStatement();
			ResultSet rst = stm.executeQuery("select * from Ventas");
			
			Venta v = null;
			
			while(rst.next()) {
				v = new Venta();
				v.setProducto(rst.getString("Producto"));
				v.setCantidad(rst.getInt("Cantidad"));
				v.setPrecio(rst.getDouble("Precio"));
				v.setDescuento(rst.getDouble("Descuento"));
				v.setSubtotal(rst.getDouble("Subtotal"));
				v.setNeto(rst.getDouble("Neto"));
				v.setIdCliente(rst.getInt("idCliente"));
				lventa.add(v);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lventa;
	}

	@Override
	public Venta buscarVenta(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
