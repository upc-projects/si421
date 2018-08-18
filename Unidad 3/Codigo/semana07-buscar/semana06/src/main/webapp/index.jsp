<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Opciones</h2>
<ul>
	<li><a href="LibroController?accion=registrar">Crear libro</a></li>
	<li><a href="LibroController">Listar libros</a></li>
	<li><a href="AutorController">Listar autores</a></li>
	<li><a href="AutorController?accion=registrar">Crear autor</a></li>
	
	<li><a href="LibroController?accion=barato">Libro más barato</a></li>
	<li><a href="LibroController?accion=caro">Libro más caro</a></li>
</ul>
</body>
</html>