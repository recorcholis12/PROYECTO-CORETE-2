package co.edu.unbosque.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import co.edu.unbosque.model.Estudiante;
import co.edu.unbosque.persistence.ArchivoCSV;
import co.edu.unbosque.persistence.Conexion;
import co.edu.unbosque.persistence.EstudianteDAO;
import co.edu.unbosque.persistence.Basedatos;


public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	private EstudianteDAO dao;
	
	public Servlet() {
		dao = new EstudianteDAO();
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String datos = "";
		for (int i = 0; i < dao.getLista().size(); i++) {
			
			datos+="    <tr>\r\n" + "      <th scope=\"row\">" + dao.getLista().get(i).getNombre()  + "</th>\r\n"
					+ "      <td>" + dao.getLista().get(i).getColegio() + "</td>\r\n" + "      <td>" + dao.getLista().get(i).getF_nacimiento()
					+ "</td>\r\n" + "      <td>" + dao.getLista().get(i).getCarrera() + "</td>\r\n" + "      <td>"
					+ dao.getLista().get(i).getHomologado()  + "</td>\r\n" + "      <td>" + dao.getLista().get(i).getEstrato()
					+ "</td>\r\n" + "</td>\r\n" + "      <td>"
					+ dao.getLista().get(i).getEdad()  + "</td>\r\n" + "</tr>\r\n";
		}
		PrintWriter salida = response.getWriter();
		salida.println("<html>");
		salida.println("<head>");
		salida.println("<title>Informacion guardada</title>");
		salida.println("<meta charset=\"UTF-8\">");
		salida.println("<link href=\"https://fonts.googleapis.com/css2?family=Secular+One&display=swap\" rel=\"stylesheet\">");
		salida.println("<link href=\"styles/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
		salida.println("<link\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\"\r\n"
				+ "	integrity=\"sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp\"\r\n"
				+ "	crossorigin=\"anonymous\">");
		salida.println("<script\r\n"
				+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "	integrity=\"sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N\"\r\n"
				+ "	crossorigin=\"anonymous\"></script>");
		salida.println("<body class=\"body3\">");
		salida.println("<br>");
		salida.println("<h1 class=\"titulos\">Personas en tabla</h1>");
		salida.println("<h2>" + "<table class=\"table table-success table-striped\">\r\n" + "  <thead>\r\n" + "    <tr>\r\n"
				+ "      <th scope=\"col\">Nombre</th>\r\n" + "      <th scope=\"col\">Colegio</th>\r\n"
				+ "      <th scope=\"col\">Fecha</th>\r\n" + "      <th scope=\"col\">Carrera</th>\r\n"
				+ "      <th scope=\"col\">Homologado</th>\r\n" + "  <th scope=\"col\">Estrato</th>\r\n"
				+ "  <th scope=\"col\">Edad</th>\r\n" + "    </tr>\r\n" + "  </thead>\r\n" + "  <tbody>\r\n"
				+ datos + "  </tbody>\r\n" + "</table>");
		salida.println("</body>");
		salida.println("</html>");
		salida.close();




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		String nombre = request.getParameter("name");
		String nacimiento = request.getParameter("nacimiento");
		String colegio = request.getParameter("colegio");
		String carrera = request.getParameter("career");
		int estrato = Integer.parseInt(request.getParameter("subject"));
		String h = request.getParameter("contact");
		int edad = dao.edad(nacimiento);
		


		dao.crear(nombre, nacimiento, edad, colegio, carrera, estrato, h);
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();

		salida.println("<html>");
		salida.println("<head>");
		salida.println("<title> lista de personas </title>");
		salida.println("<body>");
		salida.println("<h1>");
		salida.println("se agrego corectamente");
		salida.println("</h1>");
		salida.println("</body>");
		salida.println("</head>");
		salida.println("</html>");
		salida.close();

	}
}


