package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entities.Autor;
import service.IAutorService;
import service.impl.AutorServiceImpl;

@Path("/autoresWS")
public class AutorRest {
	private IAutorService autorService;
	private Gson gson;
	private String respuesta = "";
	public AutorRest() {
		autorService = new AutorServiceImpl();
		gson = new GsonBuilder().create();
	}

	@GET
	@Path("listado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listado() {
		try {
			List<Autor> autores = autorService.listar();
			respuesta = gson.toJson(autores);
			
			return Response.status(Response.Status.OK).entity(respuesta).build();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
		}
	}
	
	@POST
	@Path("guardar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crear(Autor obj) {
		try {
			boolean flag = autorService.agregar(obj);
			if(flag) {
				respuesta = gson.toJson("Autor creado");
				return Response.status(Response.Status.OK).entity(respuesta).build();
			}else {
				respuesta = gson.toJson("No se pudo crear");
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta = gson.toJson("Ocurrió un error");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
		}
	}
	
}
