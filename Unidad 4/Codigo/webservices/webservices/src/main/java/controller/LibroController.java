package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Autor;
import entities.Editorial;
import entities.Genero;
import entities.Libro;
import service.IAutorService;
import service.IEditorialService;
import service.IGeneroService;
import service.ILibroService;
import service.impl.AutorServiceImpl;
import service.impl.EditorialServiceImpl;
import service.impl.GeneroServiceImpl;
import service.impl.LibroServiceImpl;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/LibroController")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ILibroService service = null;
	IGeneroService serviceGenero = null;
	IEditorialService serviceEditorial = null;
	IAutorService serviceAutor = null;
	
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
		// TODO Auto-generated method stub
		if(request.getParameter("accion")!=null) {
			if(request.getParameter("accion").equals("registrar")) {
				serviceGenero = new GeneroServiceImpl();
				serviceEditorial =  new EditorialServiceImpl();
				serviceAutor = new AutorServiceImpl();
				
				request.setAttribute("listadoGeneros", serviceGenero.listar());				
				request.setAttribute("listadoEditoriales", serviceEditorial.listar());
				request.setAttribute("listadoAutores", serviceAutor.listar());
				
				request.getRequestDispatcher("/libro_crear.jsp").forward(request, response);
			}
		}else {
			service = new LibroServiceImpl();
			List<Libro> listado = service.listar();
			request.setAttribute("listadoLibros", listado);
			
			request.getRequestDispatcher("/libro_listado.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String genero = request.getParameter("generos");
		String editorial = request.getParameter("editoriales");
		String titulo = request.getParameter("titulo");
		String isbn = request.getParameter("isbn");
		String precio = request.getParameter("precio");
		String sinopsis = request.getParameter("sinopsis");
		String autores[] = request.getParameterValues("autor");
		
		/*Se crea el objeto Genero que se necesita para luego asignarlo al objeto Libro*/
		/*Se le asigna el ID al objeto*/
		Genero objGenero = new Genero();
		objGenero.setId(Integer.parseInt(genero));
		
		/*Se crea el objeto Editorial que se necesita para luego asignarlo al objeto Libro*/
		/*Se le asigna el ID al objeto*/
		Editorial objEditorial = new Editorial();
		objEditorial.setId(Integer.parseInt(editorial));
		
		/*Se crea el List<Autor> necesario para asignarlo al objeto Libro*/
		List<Autor> listadoAutores = new ArrayList<>();
		Autor objAutor = null;
		for(int i=0; i< autores.length; i++){
			
			objAutor = new Autor();
			objAutor.setId(Integer.parseInt(autores[i]));
			listadoAutores.add(objAutor);
		}
		
		/*Se crea el objeto Libro*/
		Libro obj = new Libro();
		obj.setGenero(objGenero);
		obj.setEditorial(objEditorial);
		obj.setTitulo(titulo);
		obj.setIsbn(isbn);
		//obj.setPrecio(Double.parseDouble(precio));
		obj.setSinopsis(sinopsis);
		obj.setAutores(listadoAutores);
		
		service = new LibroServiceImpl();
		boolean flag = service.registrar(obj);
		
		if(flag) {
			request.setAttribute("mensaje", "Libro registrado");
		}else {
			request.setAttribute("mensaje", "Ocurrió un error");
		}
		
		request.getRequestDispatcher("/resultado.jsp").forward(request, response);
	}

}
