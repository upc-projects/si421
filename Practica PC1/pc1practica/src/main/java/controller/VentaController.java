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
import dao.InterfaceVentas;
import dao.implement.ImplCliente;
import dao.implement.ImplVenta;
import entities.Cliente;
import entities.Venta;

/**
 * Servlet implementation class VentaController
 */
@WebServlet("/VentaController")
public class VentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InterfaceCliente icli = new ImplCliente();
		List<Cliente> listacliente = icli.listar();
		request.setAttribute("listaclientes",listacliente);
		request.getRequestDispatcher("/new_ventas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String precio = request.getParameter("precio");
		String idCliente = request.getParameter("idcliente");
		Venta v = new Venta();
		v.setIdCliente(Integer.parseInt(idCliente));
		v.setPrecio(Double.parseDouble(precio));
		v.setCantidad(2);
		v.setDescuento(12.1);
		v.setNeto(100.0);
		v.setProducto("wea");
		v.setSubtotal(200.0);
		
		InterfaceVentas iv = new ImplVenta();
		boolean funciono = iv.registrarVenta(v);
		if(funciono) {
			request.setAttribute("msj", "Venta exitosa");
		}else {
			request.setAttribute("msj", "gmi2 iora");
		}
		
		request.getRequestDispatcher("/resultado.jsp").forward(request, response);
	}

}
