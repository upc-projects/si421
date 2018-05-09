package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Autor;
import service.IAutorService;
import service.implement.AutorService;

/**
 * Servlet implementation class autores
 */
@WebServlet("/autores")
public class autores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAutorService serviceAutor = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public autores() {
    	super();
        serviceAutor = new AutorService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("accion") != null) {
			if(request.getParameter("accion").equals("agregar")) {
				request.getRequestDispatcher("/agregar_autor.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String nacionalidad = request.getParameter("nacionalidad");
		
		
		Autor oAutor = new Autor();
		oAutor.setNombre(nombre);
		oAutor.setApellido(apellidos);
		oAutor.setNacionalidad(nacionalidad);
		
		boolean f = serviceAutor.crearAutor(oAutor);
		if(f) {
			request.setAttribute("mensaje", "Autor creado");
		}else {
			request.setAttribute("mensaje", " :(");
		}
		
		request.getRequestDispatcher("/resultado.jsp").forward(request, response);
		
	}

}
