<%@page import="entities.Cliente"%>
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

<% List<Cliente> lc = (List<Cliente>) request.getAttribute("listaclientes"); %>

<form action="VentaController" method="post">
	Cliente : 
	<select name="idcliente">
		<% for (int i = 0 ; i < lc.size() ; i++)  { %>
			<option value="<%= lc.get(i).getId() %>"><%= lc.get(i).getNombre() %></option>
		<%} %>
	</select>
	<input type="text" name="precio" placeholder="precio">
	<input type="submit" value="guadar"> 
</form>

</body>
</html>