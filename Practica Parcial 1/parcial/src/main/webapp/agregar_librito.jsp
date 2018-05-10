<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>AGREGAR LIBRITO</h1>
<form action="LibritoController?accion=agregar" method="post"> <br>
	Titulo : <input type="text" name="titulo"> <br>
	ISBN : <input type="text" name="isbn"> <br>
	PRECIO : <input type="text" name="precio"> <br>
	<input type="submit" value="guardar"> <br>
</form>
</body>
</html>