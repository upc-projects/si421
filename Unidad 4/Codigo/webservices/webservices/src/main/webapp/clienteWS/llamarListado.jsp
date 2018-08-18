<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("button").click(function(){
	    $.getJSON( "http://localhost:8080/semana06/servicios/autoresWS/listado", function( data ) {
		    var tbl_row = "";
	    	$.each( data, function( key, val ) {
				tbl_row += "<tr><td>"+val.id+"</td><td>"+val.nombres+"</td><td>"+val.apellidos+"</td></tr>";
			})
	        $("#listadoAutores").append(tbl_row);
	    });
	});
});
</script>
</head>
<body>
<h2>Clic en el botón para invocar al método del servicio Web:</h2>
<button>Llamar al método Listado (WS)</button>
<table id="listadoAutores"></table>
</body>
</html>