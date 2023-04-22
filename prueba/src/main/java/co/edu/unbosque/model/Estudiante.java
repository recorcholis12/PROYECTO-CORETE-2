package co.edu.unbosque.model;

public class Estudiante {

	private String nombre;
	private String f_nacimiento;
	private int edad;
	private String colegio;
	private String carrera;
	private int estrato;
	private String homologado;
	
	
	public Estudiante(String nombre, String f_nacimiento, int edad, String colegio, String carrera, int estrato,
			String homologado) {
		this.nombre = nombre;
		this.f_nacimiento = f_nacimiento;
		this.edad = edad;
		this.colegio = colegio;
		this.carrera = carrera;
		this.estrato = estrato;
		this.homologado = homologado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getF_nacimiento() {
		return f_nacimiento;
	}


	public void setF_nacimiento(String f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getColegio() {
		return colegio;
	}


	public void setColegio(String colegio) {
		this.colegio = colegio;
	}


	public String getCarrera() {
		return carrera;
	}


	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	public int getEstrato() {
		return estrato;
	}


	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}


	public String getHomologado() {
		return homologado;
	}


	public void setHomologado(String homologado) {
		this.homologado = homologado;
	}


	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", f_nacimiento=" + f_nacimiento + ", edad=" + edad + ", colegio="
				+ colegio + ", carrera=" + carrera + ", estrato=" + estrato + ", homologado=" + homologado + "]";
	}
	
	
	
	
	
}
