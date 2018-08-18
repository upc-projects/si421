package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IEjemploService;
import service.impl.EjemploServiceImpl;

/**
 * Servlet implementation class AutorController
 */
@WebServlet("/EjemploController")
public class EjemploController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IEjemploService service = null;
	
    public EjemploController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = new EjemploServiceImpl();
		
		if(request.getParameter("accion")!=null) {
			if(request.getParameter("accion").equals("registrar")) {
				
				
			}else if(request.getParameter("accion").equals("eliminar")) {
				
			}
			
		}else {
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
