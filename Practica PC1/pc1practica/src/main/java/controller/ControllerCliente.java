package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InterfaceCliente;
import dao.implement.ImplCliente;
import entities.Cliente;

/**
 * Servlet implementation class ControllerCliente
 */
@WebServlet("/ControllerCliente")
public class ControllerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/new_cliente.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n = request.getParameter("nombre");
		String a = request.getParameter("apellido");
		
		Cliente cli = new Cliente();
		cli.setNombre(n);
		cli.setApellido(a);
		
		InterfaceCliente ic = new ImplCliente();
		boolean flag = ic.createCliente(cli);
		
		if(flag) {
			request.setAttribute("msj", "exito");
		}else {
			request.setAttribute("msj", "gg prro");
		}
		
		request.getRequestDispatcher("/resultado.jsp").forward(request, response);;
		
	}

}
