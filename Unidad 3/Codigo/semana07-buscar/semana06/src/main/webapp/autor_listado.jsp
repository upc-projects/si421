<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
			<th>Género</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="autor" items="${listadoAutores}">
		<tr>
			<td><c:out value="${autor.id}"></c:out></td>
			<td><c:out value="${autor.nombres}"></c:out></td>
			<td><c:out value="${autor.apellidos}"></c:out></td>
			<td><c:out value="${autor.genero}"></c:out></td>
			<td><a href="AutorController?accion=eliminar&autor=<c:out value="${autor.id}"></c:out>">eliminar</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>