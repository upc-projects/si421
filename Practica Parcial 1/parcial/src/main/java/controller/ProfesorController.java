package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Profesor;
import service.IProfesorService;
import service.implement.ProfesorService;

/**
 * Servlet implementation class ProfesorController
 */
@WebServlet("/ProfesorController")
public class ProfesorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IProfesorService profesorService = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesorController() {
        super();
        profesorService = new ProfesorService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("accion");
		if(parametro != null) {
			if(parametro.equals("agregar")) {
				request.getRequestDispatcher("/agregar_profe.jsp").forward(request, response);
			}else if(parametro.equals("codigo")) {
				request.getRequestDispatcher("/codigo_profe.jsp").forward(request, response);
			}else if(parametro.equals("eliminar")) {
				String id = request.getParameter("profeid");
				boolean flag = profesorService.eliminarProfe(Integer.parseInt(id));
				if(flag) {
					request.setAttribute("mensaje", "PROFE ELIMINADO");
					
				}else {
					request.setAttribute("mensaje", "VUELVE A INTENTAR");
				}
				request.getRequestDispatcher("/resultado.jsp").forward(request, response);
			}
		}else {
			List<Profesor> profesores = profesorService.listar();
			request.setAttribute("listaprofes", profesores);
			request.getRequestDispatcher("/lista_profes.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("accion");
		if(parametro.equals("agregar")) {
			String nombre = request.getParameter("nombre");
			String codigo = request.getParameter("codigo");
			
			Profesor p = new Profesor();
			
			p.setNombre(nombre);
			p.setCodigo(codigo);
			
			boolean flag = profesorService.crearProfe(p);
			
			if(flag) {
				request.setAttribute("mensaje", "PROFE CREADO");
				
			}else {
				request.setAttribute("mensaje", "VUELVE A INTENTAR");
			}
			request.getRequestDispatcher("/resultado.jsp").forward(request, response);
		}else if(parametro.equals("codigo")) {
			String codigo = request.getParameter("codigo");
			Profesor p = profesorService.buscarCodigo(codigo);
			if(p != null) {
				request.setAttribute("mensaje", p.getNombre());
			}else {
				request.setAttribute("mensaje", "gg");
			}
			request.getRequestDispatcher("/resultado.jsp").forward(request, response);
		}
	}

}
