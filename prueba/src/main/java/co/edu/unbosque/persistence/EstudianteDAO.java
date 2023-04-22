package co.edu.unbosque.persistence;

import java.sql.Array;
import java.util.ArrayList;

import co.edu.unbosque.model.Estudiante;

public class EstudianteDAO {

	private ArrayList<Estudiante> lista;
	private Basedatos bd;
	
	public EstudianteDAO() {
		lista = new ArrayList<Estudiante>();
		bd = new Basedatos();
		lista=bd.leer();
	}
	
	public Estudiante buscar(String nombre) {
		Estudiante tem = null;
		for (int i = 0; i < lista.size(); i++) {
			if(nombre.equals(lista.get(i).getNombre())) {
				tem = lista.get(i);
			}
		}
		return tem;
	}
	public boolean crear(String nombre, String f_nacimiento, int edad, String colegio, String carrera, int estrato,
			String homologado) {
		if(buscar(nombre)==null) {
			Estudiante tem =new Estudiante(nombre,f_nacimiento,edad,colegio,carrera,estrato,homologado);
			lista.add(tem);
			bd.escribir(tem);
			bd.getCsv().write(tem);
			
			return true;
		}
		return false;
	}
	
	public ArrayList<Estudiante> listar(String carrera){
		ArrayList<Estudiante> tem = new ArrayList<Estudiante>();
		for (int i = 0; i < lista.size(); i++) {
			Estudiante aux = lista.get(i);
			if(carrera.equals(aux.getCarrera())) {
				tem.add(aux);
			}
		}
		return tem;
	}
	
	public int edad(String f) {
		 String[] d = f.split("-");
		 int edad = 0;
		 edad = 2023-Integer.parseInt(d[0]);
		 return edad;
	}

	public ArrayList<Estudiante> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Estudiante> lista) {
		this.lista = lista;
	}
	
	
	
}
