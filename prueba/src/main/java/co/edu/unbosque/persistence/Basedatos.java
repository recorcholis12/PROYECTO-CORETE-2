package co.edu.unbosque.persistence;


import java.nio.charset.Charset;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import co.edu.unbosque.model.Estudiante;

public class Basedatos {



	private Conexion cx;
	private Connection con;
	private ArchivoCSV csv;
	
	
	
	public Basedatos() {
		csv = new ArchivoCSV();
		cx= new Conexion();
		con = cx.conectar();
		PreparedStatement ps = null;
		String sqlcreate ="CREATE TABLE IF NOT EXISTS Estudents (" 
				+ "	NOMBRE	TEXT NOT NULL,"
				+ "	NACIMIENTO	TEXT NOT NULL,"
				+ "	EDAD	INTEGER NOT NULL,"
				+ "	COLEGIO	TEXT NOT NULL,"
				+ "	CARRERA	TEXT NOT NULL,"
				+ "	ESTRATO	INTEGER NOT NULL,"
				+ "	HOMOLOGADO	TEXT NOT NULL"
				+ ");";
		try {
			ps = con.prepareStatement(sqlcreate);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	public boolean escribir(Estudiante tem) {

		
		PreparedStatement ps = null;
		String sqlcreate ="INSERT INTO Estudents VALUES(?,?,?,?,?,?,?);";
		try {
			ps = con.prepareStatement(sqlcreate);
			ps.setString(1, tem.getNombre());
			ps.setString(2, tem.getF_nacimiento());
			ps.setInt(3, tem.getEdad());
			ps.setString(4, tem.getColegio());
			ps.setString(5, tem.getCarrera());
			ps.setInt(6, tem.getEstrato());
			ps.setString(7, tem.getHomologado());
			ps.executeUpdate();
			System.out.println("registro guardado");
			System.out.println(tem.toString()+" clase basedatos");
			List<String> lineasArchivo = Files.readAllLines(csv.getArchivo().toPath(), Charset.defaultCharset());

			if (lineasArchivo.contains(tem)) {
				return false;
			} else {
				try (FileWriter escritura = new FileWriter(csv.getArchivo(), true)) {
					escritura.write(tem.toString());
					escritura.close();
					return true;
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}

		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<Estudiante> leer() {
		
		ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			pst= con.prepareStatement("SELECT NOMBRE,NACIMIENTO,EDAD,COLEGIO,CARRERA,ESTRATO,HOMOLOGADO FROM Estudents");
		    rs = pst.executeQuery();
		    while(rs.next()) {
		    	lista.add(new Estudiante(rs.getString("NOMBRE"),rs.getString("NACIMIENTO"),rs.getInt("EDAD"),rs.getString("COLEGIO"),rs.getString("CARRERA"),rs.getInt("ESTRATO"),rs.getString("HOMOLOGADO")));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
	    		if(pst!=null)
	    			pst.close();
	    		if(rs!=null)
	    			rs.close();
		    }catch( SQLException e){
		        System.err.println(e);
		    }
		}
		return lista;
	
	}


	public ArchivoCSV getCsv() {
		return csv;
	}


	public void setCsv(ArchivoCSV csv) {
		this.csv = csv;
	}

	
	
}
