<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#botonGuardar").on('click', function(){
        $.ajax({
            url: 'http://localhost:8080/semana06/servicios/autoresWS/registrar',
            type : "POST",
            dataType : 'json',
            contentType: 'application/json',
            data : JSON.stringify(ConvertFormToJSON($("#frmAutor"))),//ConvertFormToJSON($("#frmAutor")) ,
            success : function(data) {
            	$("#respuesta").text(data);
            }
        })
    });

    function ConvertFormToJSON(form){
        var array = jQuery(form).serializeArray();
        var json = {};
        
        jQuery.each(array, function() {
            json[this.name] = this.value || '';
        });

        return json;
    }
});
</script>
</head>
<body>
<h2>Registro de autor por servicio Web</h2>
<div id="respuesta" style="color:red;"></div>
<form id="frmAutor">
<div>Nombres: <input name="nombres" type="text" /> </div>
<div>Apellidos: <input name="apellidos" type="text" /> </div>
<div>Género:
	<input type="radio" value="0" name="genero" /> Masculino
	<input type="radio" value="1" name="genero" /> Femenino
</div>
<div><input type="button" id="botonGuardar" value="Guardar" /> </div>
</form>
</body>
</html>