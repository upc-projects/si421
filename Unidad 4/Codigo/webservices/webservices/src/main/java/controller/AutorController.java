package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Autor;
import service.IAutorService;
import service.impl.AutorServiceImpl;

/**
 * Servlet implementation class AutorController
 */
@WebServlet("/AutorController")
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IAutorService service = null;
	
    public AutorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("accion")!=null) {
			if(request.getParameter("accion").equals("registrar")) {
				
				request.getRequestDispatcher("/autor_agregar.jsp").forward(request, response);
			}else if(request.getParameter("accion").equals("eliminar")) {
				String id = request.getParameter("autor");
				
				service = new AutorServiceImpl();
				boolean flag = service.eliminar(Integer.parseInt(id));
				
				if(flag) {
					request.setAttribute("mensaje", "Autor eliminado");
				}else {
					request.setAttribute("mensaje", "Ocurrió un error");
				}
				
				request.getRequestDispatcher("/resultado.jsp").forward(request, response);
			}
			
		}else {
			service = new AutorServiceImpl();
			List<Autor> listado = service.listar();
			request.setAttribute("listadoAutores", listado);
			
			request.getRequestDispatcher("/autor_listado.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String genero = request.getParameter("genero");
		
		Autor obj = new Autor();
		obj.setNombres(nombres);
		obj.setApellidos(apellidos);
		obj.setGenero(Integer.parseInt(genero));

		service = new AutorServiceImpl();
		boolean flag = service.registrar(obj);
		
		if(flag) {
			request.setAttribute("mensaje", "Autor registrado");
		}else {
			request.setAttribute("mensaje", "Ocurrió un error");
		}
		
		request.getRequestDispatcher("/resultado.jsp").forward(request, response);
	}

}
