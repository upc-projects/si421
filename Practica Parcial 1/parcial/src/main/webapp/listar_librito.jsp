<%@page import="entities.Librito"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar librito</title>
</head>
<body>

<ul>
	<c:forEach items="${listalibrito}" var="librito">
	
		<li><c:out value="${librito.idlibrito }"></c:out></li>
		<li><c:out value="${librito.titulo }"></c:out></li>
		<li><c:out value="${librito.isbn }"></c:out></li>
		<li><c:out value="${librito.precio }"></c:out></li>
		<li><a href="LibritoController?accion=eliminar&librito=<c:out value="${librito.idlibrito }"/>">eliminar</a></li>
		<br> <br>
	</c:forEach>
</ul>



</body>
</html>