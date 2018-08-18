<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h2>Listado de libros</h2>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Titulo</th>
			<th>Editorial</th>
			<th>Genero</th>
			<th>Autores</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="libro">
		<tr>
			<td><c:out value="${libro.id}"></c:out></td>
			<td><c:out value="${libro.titulo}"></c:out></td>
			<td><c:out value="${libro.editorial.nombre}"></c:out></td>
			<td><c:out value="${libro.genero.nombre}"></c:out></td>
			<td><c:out value="${libro.autores}"></c:out></td>
			<td><a href="libros?accion=eliminar&libro=<c:out value="${libro.id}"></c:out>">eliminar</a></td>
		</tr>
		</c:forEach>	
	</tbody>
</table>

</body>
</html>