<%@page import="entidades.Editorial"%>
<%@page import="entidades.Genero"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crear Libro</title>
</head>
<body>

<%List<Genero> generos = (List<Genero>)request.getAttribute("listadoGeneros"); List<Editorial> editoriales = (List<Editorial>) request.getAttribute("listadoEditorial");%>

	<h2>Nuevo libro</h2>

	<form action="libroController" method="post">
		<div>
			Genero:
			<select name="genero">
			<% for(int i = 0 ; i< generos.size() ; i++){ %>
					<option value=<%=generos.get(i).getId()%>> <%=generos.get(i).getNombre()%></option>
			<% } %>
			</select>
		</div>
		
		<div>
			Editorial:
			<select name="editorial">
			<% for(int i = 0 ; i< editoriales.size() ; i++){ %>
					<option value=<%=editoriales.get(i).getId()%>> <%=editoriales.get(i).getNombre()%> </option>
			<% } %>
			</select>
		</div>
		
		<div>Titulo : <input type="text" name="titulo" /></div>
		<div>Precio : <input type="text" name="precio" /></div>
		<div>ISBN : <input type="text" name="isbn" /></div>
		<div>Descripcion : <input type="text" name="descripcion" /></div>
		<div> <input type="submit" value="save" /></div>
		
	</form>
</body>
</html>