<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LISTA PROFES</h1>

<ul>

<c:forEach items="${listaprofes}" var="profe">

	<li> <c:out value="${ profe.idprofesores}"></c:out> </li> 
	<li> <c:out value="${ profe.nombre}"></c:out> </li>
	<li> <c:out value="${ profe.codigo}"></c:out> </li>
	<li> <a href="ProfesorController?accion=eliminar&profeid=<c:out value="${ profe.idprofesores}"></c:out> "> Eliminar</a></li>
	
	<br>
	
</c:forEach>
</ul>
</body>
</html>