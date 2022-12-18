<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asociar Kart a Pista</title>
<link href="../views/formStyles.css" rel="stylesheet" type="text/css">
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
		<form method="post" action="/Práctica3/PostAsociarKartPista">
		    <h2 id="respuesta">Espere mientras carga</h2>
		    <div id="noPistas" style="color:red;"></div>
			<div class="field">
				<label for="Nombre">Nombre Pista: </label>
				<select id="miSelect1" name="Nombre">
				</select>
			</div>
			<br/>
			<div id="noKarts" style="color:red;"></div>
			<div class="field">
				<label for="ID">ID Kart: </label>
				<select id="miSelect2" name="ID">
				</select>
			</div>
			<br />
			<input type="submit" value="Asociar">
		</form>
	</div>
	
    <script>
    window.onload = function realizarSolicitud1() {
        // Realizar una solicitud GET al servlet
        fetch("/Práctica3/GetTracksChild")
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
				
				const texto = "Empareje la Pista con el Kart";
	                document.getElementById("respuesta").innerHTML = texto;
	    	});
        
     	// Realizar una solicitud GET al servlet
        fetch("/Práctica3/GetKartChild")
            .then(response => response.text()) // Obtener la respuesta como texto plano
            .then(data => {
            	if(data == ''){
		        	document.getElementById("noKarts").innerHTML = "No hay Pistas con estas características"
		        }
                // Procesar la respuesta del servlet
                var substrings = data.split(",");
	                
				// Obtener una referencia al select del formulario con un ID de "miSelect"
				var miSelect2 = document.getElementById("miSelect2");
			
				// Guardo en una string todo el html que quiero insertar
				var htmlParaInsertar = "";
				for (var i = 0; i < substrings.length; i++) {
					 htmlParaInsertar = htmlParaInsertar + "<option>" + substrings[i] + "</option>";
				}
				
				// inserto el Html
				miSelect2.innerHTML= htmlParaInsertar;
	    	});

    } 
    </script>
</body>
</html>