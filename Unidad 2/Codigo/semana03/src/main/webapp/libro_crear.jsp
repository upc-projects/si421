<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="entidades.Editorial"%>
<%@page import="entidades.Genero"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<%
	List<Genero> generos = 
				(List<Genero>)request.getAttribute("listadoGeneros");
	List<Editorial> editoriales = 
				(List<Editorial>)request.getAttribute("listadoEditoriales");
%>
<h2>Nuevo libro</h2>
<form action="libroController" method="post">
<div>Genero:
	<select name="genero">
		<% for(int i=0; i<generos.size(); i++){ %>
			<option value="<%=generos.get(i).getId()%>"><%=generos.get(i).getNombre()%></option>
		<% } %>
	</select>
</div>
<div>Editorial:
	<select name="editorial">
		<% for(int i=0; i<editoriales.size(); i++){ %>
			<option value="<%=editoriales.get(i).getId()%>"><%=editoriales.get(i).getNombre()%></option>
		<% } %>
	</select>

</div>
<div>Titulo:<input type="text" name="titulo" /> </div>
<div>Precio:<input type="text" name="precio" /> </div>
<div>ISBN:<input type="text" name="isbn" /> </div>
<div>Descripción: <textarea rows="5" cols="10" name="descripcion"></textarea> </div>
<div><input type="submit" value="Guardar" /> </div>
</form>
</body>
</html>