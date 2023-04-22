package co.edu.unbosque.persistence;

import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Estudiante;

public class ArchivoCSV {

	private File archivo ;


	public ArchivoCSV() {
		archivo = new File("datos.csv");
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void write(Estudiante lista) {
		try {
System.out.println(lista.toString()+" clase Archivo");
			FileWriter bw = new FileWriter(archivo,true);
			bw.write(lista.getNombre()+","+lista.getF_nacimiento()+","+lista.getEdad()+","+lista.getColegio()+","+lista.getCarrera()+","+lista.getEstrato()+","+lista.getHomologado()+"\r\n");
			bw.close();
			System.out.println("se escribio en el archivo csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	
}
