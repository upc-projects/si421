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
<h2>Listado de autores</h2>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Nombres</th>
			<th>Apellidos</th>
			<th>Nacionalidad</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${autores}" var="autor">
		<tr>
			<td><c:out value="${autor.id}"></c:out></td>
			<td><c:out value="${autor.nombres}"></c:out></td>
			<td><c:out value="${autor.apellidos}"></c:out></td>
			<td><c:out value="${autor.nacionalidad}"></c:out></td>
			<td><a href="autores?accion=eliminar&autor=<c:out value="${autor.id}"></c:out>">eliminar</a></td>
		</tr>
		</c:forEach>	
	</tbody>
</table>

</body>
</html>