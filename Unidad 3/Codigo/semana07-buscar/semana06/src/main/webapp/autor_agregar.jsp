<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Registro de autor</h2>
<form action="AutorController" method="post" >
<div>Nombres: <input name="nombres" type="text" /> </div>
<div>Apellidos: <input name="apellidos" type="text" /> </div>
<div>Género:
	<input type="radio" value="0" name="genero" /> Masculino
	<input type="radio" value="1" name="genero" /> Femenino
</div>
<div><input type="submit" value="Guardar" /> </div>
</form>
</body>
</html>