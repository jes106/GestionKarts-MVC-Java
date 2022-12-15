<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir una Pista</title>
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
		<form method="post" action="../controllers/registerController.jsp">
	    <h2 id="respuesta">Espere mientras carga</h2>
			<div class="field">
				<label for="Nombre">Nombre: </label>
				<select id="miSelect" name="Nombre" required>
				</select>
			</div>
		</form>
	</div>
	
    <script>
    window.onload = function realizarSolicitud() {
            // Realizar una solicitud GET al servlet
            fetch("/Práctica3/GetTracksChild")
                .then(response => response.text()) // Obtener la respuesta como texto plano
                .then(data => {
                    // Procesar la respuesta del servlet
                    var substrings = data.split(",");
                    
					// Obtener una referencia al select del formulario con un ID de "miSelect"
					var miSelect = document.getElementById("miSelect");

					// Guardo en una string todo el html que quiero insertar
					var htmlParaInsertar = "";
					for (var i = 0; i < substrings.length; i++) {
						 htmlParaInsertar = htmlParaInsertar + "<option>" + substrings[i] + "</option>";
					}
					
					// inserto el Html
					miSelect.innerHTML= htmlParaInsertar;
					
					const texto = "Elija la pista";
                    document.getElementById("respuesta").innerHTML = texto;
                });
        }
    </script>
</body>
</html>