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
		
		IGeneroDAO generoDAO = new GeneroDAO();
		List<Genero> generos = generoDAO.listar();
		
		IEditorialDAO editorialDAO = new EditorialDAO();
		List<Editorial> editoriales = editorialDAO.listar();
		
		request.setAttribute("listadoGeneros", generos);
		request.setAttribute("listadoEditoriales", editoriales);
		
		request.
			getRequestDispatcher("/libro_crear.jsp").
				forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String titulo = request.getParameter("titulo");
		String precio = request.getParameter("precio");
		String isbn = request.getParameter("isbn");
		String descripcion = request.getParameter("descripcion");
		String genero = request.getParameter("genero");
		String editorial = request.getParameter("editorial");
	
		Libro objLibro = new Libro();
		objLibro.setTitulo(titulo);
		objLibro.setPrecio(Double.parseDouble(precio));
		objLibro.setIsbn(isbn);
		objLibro.setDescripcion(descripcion);
		objLibro.setGeneroID(Integer.parseInt(genero));
		objLibro.setEditorialID(Integer.parseInt(editorial));
		
		ILibroDAO libroDAO = new LibroDAO();
		boolean flag = libroDAO.crear(objLibro);
		
		if(flag) {
			request.setAttribute("mensaje", "Libro registrado");
		}else {
			request.setAttribute("mensaje", "Ocurrió un error");
		}
		
		request.getRequestDispatcher("/resultado.jsp").forward(request, response);
	}

}
