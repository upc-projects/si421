package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IEditorialDAO;
import dao.IGeneroDAO;
import dao.ILibroDAO;
import dao.impl.EditorialDAO;
import dao.impl.GeneroDAO;
import dao.impl.LibroDAO;
import entidades.Editorial;
import entidades.Genero;
import entidades.Libro;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/libroController")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IGeneroDAO gen = new GeneroDAO();
		List<Genero> generos = gen.listar();
		
		IEditorialDAO lista = new EditorialDAO();
		List<Editorial> editoriales = lista.listar();
		
		request.setAttribute("listadoGeneros",generos);
		request.setAttribute("listadoEditorial", editoriales);
		
		request.getRequestDispatcher("/Libro_Crear.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		ILibroDAO libro = new LibroDAO();
		Libro objLibro = new Libro();
		objLibro.setTitulo(request.getParameter("titulo"));
		objLibro.setDescripcion(request.getParameter("descripcion"));
		objLibro.setIsbn(request.getParameter("isbn"));
		objLibro.setPrecio(Double.parseDouble( request.getParameter("precio")));
		objLibro.setGenero_id(Integer.parseInt( request.getParameter("genero")));
		objLibro.setEditorial_id(Integer.parseInt( request.getParameter("editorial")));
		boolean flag = libro.crear(objLibro);
		System.out.println(flag);
		
		if(flag) {
			request.setAttribute("mensaje", "Exito");
		}else {
			request.setAttribute("mensaje", "Nel");
		}
		
		request.getRequestDispatcher("/resultado.jsp").forward(request, response);
	}

}
