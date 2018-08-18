<%@page import="java.util.List"%>
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
<h2>Crear libro</h2>
<form action="libros" method="post">
<div>
	Género <select name="generos">
		<c:forEach items="${listadoGeneros}" var="genero">
			<option value="<c:out value="${genero.id}" />">
			<c:out value="${genero.nombre}" />
			</option>
		</c:forEach>
	</select>
</div>
<div>
	Editorial
	<select name="editoriales">
		<c:forEach items="${listadoEditoriales}" var="editorial">
			<option value="<c:out value="${editorial.id}" />">
			<c:out value="${editorial.nombre}" />
			</option>
		</c:forEach>
	</select>
</div>
<div>Titulo <input type="text" name="titulo" /></div>
<div>ISBN <input type="text" name="isbn" /></div>
<div>Precio <input type="text" name="precio" /></div>
<div>Sinopsis 
<textarea name="sinopsis" rows="7" cols="7"></textarea> </div>

<div>
Autores:
<c:forEach items="${listadoAutores}" var="autor">
<input type="checkbox" name="autor" value="<c:out value="${autor.id}"></c:out>" /> <c:out value="${autor.nombres}"></c:out>
</c:forEach>
</div>
<div><input type="submit" value="Guardar" >  </div>
</form>
</body>
</html>