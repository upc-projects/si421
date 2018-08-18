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

@WebServlet("/autores")
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IAutorService serviceAutor = null;

    public AutorController() {
    	serviceAutor = new AutorServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("accion") != null) {
			if(request.getParameter("accion").equals("agregar")) {
				
				request.getRequestDispatcher("/autor_agregar.jsp").forward(request, response);
			}else if(request.getParameter("accion").equals("eliminar")) {
				
				String autor = request.getParameter("autor");
				boolean flag = serviceAutor.eliminar(Integer.parseInt(autor));
				
				if(flag) {
					request.setAttribute("mensaje", "Autor eliminado");
				}else {
					request.setAttribute("mensaje", "Ocurrió un error");
				}
				request.getRequestDispatcher("/resultado.jsp").forward(request, response);
				
			}
		}else {
			List<Autor> autores = serviceAutor.listar();
			request.setAttribute("autores", autores);
			request.getRequestDispatcher("/autor_listado.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String nacionalidad = request.getParameter("nacionalidad");
		
		Autor obj = new Autor();
		obj.setNacionalidad(nacionalidad);
		obj.setApellidos(apellidos);
		obj.setNombres(nombres);
		
		boolean flag = serviceAutor.agregar(obj);
		if(flag) {
			request.setAttribute("mensaje", "Autor registrado");
		}else {
			request.setAttribute("mensaje", "Ocurrió un error");
		}
		request.getRequestDispatcher("/resultado.jsp").forward(request, response);
		
	}

}
