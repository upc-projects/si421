<%@page import="java.util.ArrayList"%>
<%@page import="entities.Venta"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% List<Venta> lv = (ArrayList<Venta>) request.getAttribute("listaventas"); %>

<h1>VENTAS</h1>

	<p><%=lv.get(0).getIdCliente()%></p>


</body>
</html>