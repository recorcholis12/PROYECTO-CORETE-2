package co.edu.unbosque.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	Connection conectar =null;

	public Connection conectar() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			conectar = DriverManager.getConnection("jdbc:sqlite:datos.db");
		
			System.out.println("conexion exitosa");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error de coneccion");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conectar;
	}
	
	public void desconectar() {
		try {
			conectar.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
