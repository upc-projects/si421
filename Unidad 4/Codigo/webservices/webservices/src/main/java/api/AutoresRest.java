package api;

import java.lang.reflect.Modifier;
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
public class AutoresRest {
	private IAutorService servicioAutor;
	
	private Gson gson;
	
	public AutoresRest() {
		gson=new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
		servicioAutor = new AutorServiceImpl();
	}

	@GET
	@Path("mensaje")
	@Produces(MediaType.TEXT_PLAIN)
	public String mensajePrueba() {
		return "Mensaje Autores REST";
	}
	
	@GET
	@Path("listado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response todosAutores(){
		String respuesta = "";
		try {
			List<Autor> listado = servicioAutor.listar();
			System.out.println(listado.size());
			respuesta = gson.toJson(listado);
		} catch (Exception e) {
			System.out.println(e.getMessage());

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
		}
		return Response.status(Response.Status.OK).entity(respuesta).build();
	}
	
	@POST
	@Path("registrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearAutor(Autor obj) {
		String respuesta;
		
		try {
			boolean flag = servicioAutor.registrar(obj);
			if(flag){
				respuesta = gson.toJson("Autor creado satisfactoriamente");
			}else{
				respuesta = gson.toJson("Ocurrio un error");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Response.Status.OK).entity(respuesta).build();
	}
}
