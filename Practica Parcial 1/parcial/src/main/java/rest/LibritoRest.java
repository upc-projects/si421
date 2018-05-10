package rest;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entities.Librito;
import service.ILibritoService;
import service.implement.LibritoService;

@Path("/libritoWS")
public class LibritoRest {
	Gson gson;
	ILibritoService serviceLibrito;
	
	public LibritoRest() {
		gson = new GsonBuilder().create();
		serviceLibrito = new LibritoService();
	}
	
	@GET
	@Path("listado")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		String respuesta = "";
		try {
			List<Librito> libritos = serviceLibrito.listar();
			respuesta = gson.toJson(libritos);
			return Response.status(Response.Status.OK).entity(respuesta).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
		}
	}
	
	@POST
	@Path("creacion")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearLibrito(Librito l) {
		String respuesta ="";
		try {
			boolean flag = serviceLibrito.crearLibrito(l);
			if(flag) {
				respuesta = gson.toJson("Creado");
				return Response.status(Response.Status.OK).entity(respuesta).build();
			}else {
				respuesta = gson.toJson("Error");
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta = gson.toJson("Error");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
		}
		
	}
	
	
}
