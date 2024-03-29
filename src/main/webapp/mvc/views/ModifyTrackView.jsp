<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Kart</title>
<link href="/Práctica3/mvc/views/formStyles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		if(request.getParameter("error") != null) {
	%>
	<div class="animation">
	<div class="error"><%= request.getParameter("error") %></div>
	</div>
	<%
		}
	%>
	<div class="note-form">
		<form method="post" action="/Práctica3/PostModifyTrack">
		    <h2 id="respuesta">Espere mientras carga</h2>
		    <div id="noPistas" style="color:red;"></div>
			<div class="field">
				<label for="Nombre">ID Pista: </label>
				<select id="miSelect1" name="Nombre">
				</select>
			</div>
			<br/>
			<div class="field">
				<label for="ID">Estado Pista: </label>
				<select name="Estado" required>
				<option>Disponible</option>
				<option>Mantenimiento</option>
			</select>
			</div>
			<br />
			<input type="submit" value="Modificar">
		</form>
	</div>
	
    <script>
    window.onload = function realizarSolicitud1() {
        // Realizar una solicitud GET al servlet
        fetch("/Práctica3/GetTracks")
            .then(response => response.text()) // Obtener la respuesta como texto plano
            .then(data => {
            	if(data == ''){
		        	document.getElementById("noPistas").innerHTML = "No hay Pistas con estas características"
		        }
                // Procesar la respuesta del servlet
                var substrings = data.split(",");
	                
				// Obtener una referencia al select del formulario con un ID de "miSelect"
				var miSelect1 = document.getElementById("miSelect1");
			
				// Guardo en una string todo el html que quiero insertar
				var htmlParaInsertar = "";
				for (var i = 0; i < substrings.length; i++) {
					 htmlParaInsertar = htmlParaInsertar + "<option>" + substrings[i] + "</option>";
				}
				
				// inserto el Html
				miSelect1.innerHTML= htmlParaInsertar;
				
				const texto = "Seleccione la Pista y su Estado";
	                document.getElementById("respuesta").innerHTML = texto;
	    	});
    } 
    </script>
</body>
</html>