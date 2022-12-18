<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="usuario" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar reserva</title>
<link href="../formStyles.css" rel="stylesheet" type="text/css">
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
		<form method="post" action="/Práctica3/PostEliminarReservas">
		    <h2 id="respuesta">Espere mientras carga</h2>
			<div class="field">
				<label for="ID">ID de Reserva: </label>
				<div id="noReservas" style="color:red;"></div>
				<select id="miSelect1" name="ID">
				</select>
			</div>
			<br/>
			<input class="red" type="submit" value="Eliminar">
		</form>
	</div>
	
	<!-- esto es un formulario oculto para poder pasarle el email a la paeticion get -->
	<form id="miFormulario" style="display:none;">
		<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %>>
	</form>
	
    <script>
    window.onload = function realizarSolicitud1() {
    	
    	const formulario = document.getElementById('miFormulario');
    	const searchParams = new URLSearchParams();
	   	searchParams.set('Email', formulario.elements.Email.value);
	   	  
	   	const url = "/Práctica3/GetReservasUsuarioModificables?" + searchParams.toString();
        // Realizar una solicitud GET al servlet
        fetch(url)
            .then(response => response.text()) // Obtener la respuesta como texto plano
            .then(data => {
            	console.log(data);
            	if(data == ''){
            		document.getElementById("noReservas").innerHTML = "No tienes reservas con más de 24 horas de antelación"
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
				
				const texto = "Seleccione la Reserva a eliminar";
	                document.getElementById("respuesta").innerHTML = texto;
	    	});
    } 
    </script>
</body>
</html>