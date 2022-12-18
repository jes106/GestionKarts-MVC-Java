<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="usuario" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bonos</title>
<link href="../../formStyles.css" rel="stylesheet" type="text/css">
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
	
	<h2>Elige el tipo de bono</h2>
	<br>
	<div class="botones">
		<a href="#" onclick="Infantil()">Infantil</a>
		<a href="#" onclick="Familiar()">Familiar</a>
		<a href="#" onclick="Adulto()">Adulto</a>
	</div>
	
	<div class="botones">
		<a id="bono">Nuevo Bono</a>
		<a id="bono">Nuevo Bono</a>
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
	  function Infantil() {
		  
		document.getElementById("botones").innerHTML = "<a href="/Práctica3/mvc/views/ClientViews/ReservasBono/ReservaBonoInfantil.jsp">Nuevo Bono</a>";
	   	
	   	const searchParams = new URLSearchParams();
	   	searchParams.set('Tipo', 'infantil');
	   	searchParams.set('Email', <%= usuario.getUsuario() %>);
	   	  
	   	const url = "/Práctica3/GetTieneBono?" + searchParams.toString();
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