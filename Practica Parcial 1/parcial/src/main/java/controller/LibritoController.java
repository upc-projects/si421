package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Librito;
import service.ILibritoService;
import service.implement.LibritoService;

/**
 * Servlet implementation class LibritoController
 */
@WebServlet("/LibritoController")
public class LibritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ILibritoService serviceLibrito = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibritoController() {
        super();
        serviceLibrito = new LibritoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("accion")!= null) {
			if(request.getParameter("accion").equals("agregar")) {
				request.getRequestDispatcher("/agregar_librito.jsp").forward(request, response);
			}
			else if(request.getParameter("accion").equals("isbn")) {
				request.getRequestDispatcher("/buscar_isbn.jsp").forward(request, response);
			}else if(request.getParameter("accion").equals("eliminar")) {
				String id = request.getParameter("librito");
				boolean flag = serviceLibrito.eliminarLibrito(Integer.parseInt(id));
				if(flag) {
					request.setAttribute("mensaje", "librito eliminado!!");
				}else {
					request.setAttribute("mensaje", "no eliminado CTMR");
				}
				
				request.getRequestDispatcher("/resultado.jsp").forward(request, response);
			}
		}else {
			List<Librito> lista = new ArrayList<Librito>();
			lista = serviceLibrito.listar();
			request.setAttribute("listalibrito", lista);
			request.getRequestDispatcher("/listar_librito.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("accion").equals("agregar")) {
			
			String titulo = request.getParameter("titulo");
			String isbn = request.getParameter("isbn");
			String precio = request.getParameter("precio");
			
			Librito oLibrito = new Librito();
			oLibrito.setPrecio(Double.parseDouble(precio));
			oLibrito.setTitulo(titulo);
			oLibrito.setIsbn(isbn);
			
			boolean flag = serviceLibrito.crearLibrito(oLibrito);
			if(flag) {
				request.setAttribute("mensaje", "EXITOOOO!!");
			}else {
				request.setAttribute("mensaje", "FAIL CTMR");
			}
			
			request.getRequestDispatcher("/resultado.jsp").forward(request, response);
		} else if(request.getParameter("accion").equals("isbn")) {
			String isbn = request.getParameter("isbnLibrito");
			Librito librito = serviceLibrito.listarISBN(isbn);
			if(librito != null) {
				request.setAttribute("mensaje", librito.getTitulo());
			}else {
				request.setAttribute("mensaje", "LA CAGASTE");
			}
			request.getRequestDispatcher("/resultado.jsp").forward(request, response);
		}
		
		
	}

}
