<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="usuario" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Pistas</title>
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
	    <form id="miFormulario" action="#" onsubmit="return peticion()">
			<div class="field">
				<label for="Tipo">Dificultad de la pista: </label>
				<select name="Tipo" required>
					<option>Infantil</option>
					<option>Familiar</option>
					<option>Adultos</option>
				</select>
			</div>
			<br/>
			<div class="field">
				<label for="Date">Fecha: </label>
				<input type="date" name="Date" value="" required>
				<input type="time" name="Time" value="" required>
			</div>
			<br/>
			<div class="field">
				<label for="Min">Nº Mínimo de Karts: </label>
				<input type="number" name="Min" required>
			</div>
			<p style="display:none;">
			<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %>>
			</p>
			<br />
			<button type="submit">Pedir Pistas</button>
			<br />
		</form>
	</div>
	
	<div class="note-form">
		<form method="post" action="/Práctica3/PostReservaIndividual">
		    <h2 id="respuesta">Esperando que pida las pistas...</h2>
			<div class="field">
				<select id="miSelect1" name="Nombre">
				</select>
			</div>
			<p id="ocultos" style="display:none;">
			</p>
			<input type="submit" value="Reservar">
		</form>
	</div>

	<script>
	  function peticion() {
		const formulario = document.getElementById('miFormulario');
	   	
	   	const searchParams = new URLSearchParams();
	   	searchParams.set('Tipo', formulario.elements.Tipo.value);
	   	searchParams.set('Date', formulario.elements.Date.value);
	   	searchParams.set('Time', formulario.elements.Time.value);
	   	searchParams.set('Min', formulario.elements.Min.value);
	   	searchParams.set('Email', formulario.elements.Email.value);
	   	
	   	var ParametrosOcultos = '<input type="text" readonly name="Tipo" value="' + formulario.elements.Tipo.value + '">' + 
	    '<input type="text" readonly name="Date" value="' + formulario.elements.Date.value + '">' + 
	    '<input type="text" readonly name="Time" value="' + formulario.elements.Time.value + '">' + 
	    '<input type="text" readonly name="Min" value="' + formulario.elements.Min.value + '">' + 
	    '<input type="text" readonly name="Email" value="' + formulario.elements.Email.value + '">';
	    document.getElementById('ocultos').innerHTML = ParametrosOcultos;
	   	  
	   	const url = "/Práctica3/GetPistasDisponibles?" + searchParams.toString();
		//console.log(url);
	   	fetch(url)
	      .then(response => response.text())
	      .then(data => {
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
			  
	    	const texto = "Seleccione la Pista";
            document.getElementById("respuesta").innerHTML = texto;
	  	});
	    return false;
	  }
	</script>
    
</body>
</html>