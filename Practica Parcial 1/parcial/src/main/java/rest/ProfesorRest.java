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

import entities.Profesor;
import service.IProfesorService;
import service.implement.ProfesorService;

@Path("/profesoresWS")
public class ProfesorRest {

	IProfesorService profesorService = null;
	Gson gson = null;
	
	public ProfesorRest() {
		gson = new GsonBuilder().create();
		profesorService = new ProfesorService();
	}
	
	@GET
	@Path("listado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarProfes() {
		String resultado = "";
		try {
			List<Profesor> ps = profesorService.listar();
			resultado = gson.toJson(ps);
			return Response.status(Response.Status.OK).entity(resultado).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resultado).build();
		}
	}
	
	
	@POST
	@Path("creacion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearProfe(Profesor p) {
		String resultado = "";
		try {
			boolean flag = profesorService.crearProfe(p);
			if(flag) {
				resultado = gson.toJson("Profe creado");
				return Response.status(Response.Status.OK).entity(resultado).build();
			}else {
				resultado = gson.toJson("Error");
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resultado).build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resultado).build();
		}
	}
}
