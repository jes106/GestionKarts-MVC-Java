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
	
	<br><h2>Elige el tipo de bono</h2><br>
	
	<div class="botones">
		<a href="#" onclick="Infantil()">Infantil</a>
		<a href="#" onclick="Familiar()">Familiar</a>
		<a href="#" onclick="Adulto()">Adulto</a>
	</div>

	<div id="bono">
	</div>
	
	<div id="visibilidad" style="display:none;">
	<div class="note-form">
	    <form id="FormularioReserva" action="#" onsubmit="return FormularioReserva()">
	    	<h2>Selecciona la fecha y los participantes</h2>
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
		<form method="post" action="/Práctica3/PostReservarConNuevoBono">
		    <h2 id="respuesta">Esperando que pida las pistas...</h2>
		    <div id="noPistas" style="color:red;"></div>
			<div class="field">
				<select id="miSelect1" name="Nombre">
				</select>
			</div>
			<p id="visibles">
			</p>
			<p id="ocultos" style="display:none;">
			</p>
			<input type="text" readonly name="Bono" value="true" style="display:none;">
			<input type="submit" value="Crear Bono y Reservar">
		</form>
	</div>
	</div>
	
	

	<script>
	  function Infantil() {
			if(document.getElementById("visibilidad").style.display == ""){
				ocultar();	
			}
		//muestro el boton que envia un formulario oculto con los datos para la ceracion del bono
		document.getElementById("bono").innerHTML = '<form id="miFormulario" method="" action="">' + 
		'<input type="text" readonly name="Tipo" value="Infantil" style="display:none;">' + 
		'<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %> style="display:none;">' + 
		'<button href="#" onclick="visibilidad()">Crear Bono Infantil y Reservar</button></form>';	
	    return false;
	  }
	  function Familiar() {
			if(document.getElementById("visibilidad").style.display == ""){
				ocultar();	
			}
			//muestro el boton que envia un formulario oculto con los datos para la ceracion del bono
			document.getElementById("bono").innerHTML = '<form id="miFormulario" method="" action="">' + 
			'<input type="text" readonly name="Tipo" value="Familiar" style="display:none;">' + 
			'<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %> style="display:none;">' + 
			'<button href="#" onclick="visibilidad()">Crear Bono Familiar y Reservar</button></form>';	
		    return false;
		  }
	  function Adulto() {
			if(document.getElementById("visibilidad").style.display == ""){
				ocultar();	
			}
			//muestro el boton que envia un formulario oculto con los datos para la ceracion del bono
			document.getElementById("bono").innerHTML = '<form id="miFormulario" method="" action="">' + 
			'<input type="text" readonly name="Tipo" value="Adultos" style="display:none;">' + 
			'<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %> style="display:none;">' + 
			'<button href="#" onclick="visibilidad()">Crear Bono Adulto y Reservar</button></form>';
		    return false;
		  }
	  
	  function visibilidad() {
		  	document.getElementById("visibilidad").style.display = "";
		  	document.getElementById("bono").style.display = "none";	
	  }
	  
	  function ocultar() {
		  	document.getElementById("visibilidad").style.display = "none";
		  	document.getElementById("bono").style.display = "";	
	  }
	  
	  
	  function FormularioReserva() {
			const formulario = document.getElementById('FormularioReserva');
			const dificultad= document.getElementById('miFormulario');
		   	
		   	const searchParams = new URLSearchParams();
		   	searchParams.set('Tipo', dificultad.elements.Tipo.value); //la dificultad la cojo del formulario inivsible que se crea al pulsar el boton
		   	searchParams.set('Date', formulario.elements.Date.value);
		   	searchParams.set('Time', formulario.elements.Time.value);
		   	searchParams.set('Min', formulario.elements.Min.value);
		   	searchParams.set('Email', formulario.elements.Email.value);
		   	
		   	var ParametrosOcultos = '<input type="text" readonly name="Tipo" value="' + dificultad.elements.Tipo.value + '">' + 
		    '<input type="text" readonly name="Date" value="' + formulario.elements.Date.value + '">' + 
		    '<input type="text" readonly name="Time" value="' + formulario.elements.Time.value + '">' + 
		    '<input type="text" readonly name="Min" value="' + formulario.elements.Min.value + '">' + 
		    '<input type="text" readonly name="Email" value="' + formulario.elements.Email.value + '">';
		    document.getElementById('ocultos').innerHTML = ParametrosOcultos;
		   	
		    var ParametrosVisibles = '<div class="field"><label for="Duracion">Duración de la reserva: </label><select name="Duracion" required><option>60</option><option>90</option><option>120</option></select></div><br>';
			
		    if(dificultad.elements.Tipo.value == 'Infantil'){
		    	ParametrosVisibles = ParametrosVisibles + '<div class="field"><label for="Child">Numero de menores: </label><input type="number" name="Child" value="" required></div>';
		    }
		    else if(dificultad.elements.Tipo.value == 'Familiar'){
		    	ParametrosVisibles = ParametrosVisibles + '<div class="field"><label for="Child">Numero de menores: </label><input type="number" name="Child" value="" required></div><br>' +
		    	'<div class="field"><label for="Adult">Numero de adultos: </label><input type="number" name="Adult" value="" required></div>';
		    }
		    else{
		    	ParametrosVisibles = ParametrosVisibles + '<div class="field"><label for="Adult">Numero de adultos: </label><input type="number" name="Adult" value="" required></div>';
		    }
		    document.getElementById('visibles').innerHTML = ParametrosVisibles;
		    
		    
		   	const url = "/Práctica3/GetPistasDisponibles?" + searchParams.toString();
			//console.log(url);
		   	fetch(url)
		      .then(response => response.text())
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
				  
		    	const texto = "Seleccione la Pista";
	            document.getElementById("respuesta").innerHTML = texto;
		  	});
		    return false;
		  }
	</script>
    
</body>
</html>