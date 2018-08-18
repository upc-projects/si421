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
<h2>Listado de libros</h2>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Titulo</th>
			<th>Precio</th>
			<th>ISBN</th>
			<th>Genero</th>
			<th>Editorial</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="libro" items="${listadoLibros}">
		<tr>
			<td><c:out value="${libro.id}"></c:out></td>
			<td><c:out value="${libro.titulo}"></c:out></td>
			<td><c:out value="${libro.precio}"></c:out></td>
			<td><c:out value="${libro.isbn}"></c:out></td>
			<td><c:out value="${libro.genero.nombre}"></c:out></td>
			<td><c:out value="${libro.editorial.nombre}"></c:out></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>