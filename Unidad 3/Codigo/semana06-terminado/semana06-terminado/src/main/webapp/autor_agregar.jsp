<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h2>Agregar autor</h2>
<form action="autores" method="post">
<div>Nombres: <input type="text" name="nombres" /> </div>
<div>Apellidos: <input type="text" name="apellidos" /> </div>
<div>Nacionalidad: <input type="text" name="nacionalidad" /> </div>
<div><input type="submit" value="Guardar" /> </div>
</form>
</body>
</html>