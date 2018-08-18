package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public static Connection conectar() {
		Connection conexion = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/BASEDATOS?autoReconnect=true&useSSL=false";
			//
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, "root", "");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return conexion;
	}
	
	public static void cerrar(Connection conexion) {
		
		try {
			conexion.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
