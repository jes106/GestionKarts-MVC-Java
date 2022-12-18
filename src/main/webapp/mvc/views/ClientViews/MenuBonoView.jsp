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
	<div id="reservar">
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
				<label for="Min">N� M�nimo de Karts: </label>
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
		<form method="post" action="/Pr�ctica3/PostReservaIndividual">
		    <h2 id="respuesta">Esperando que pida las pistas...</h2>
			<div class="field">
				<select id="miSelect1" name="Nombre">
				</select>
			</div>
			<p id="visibles">
			</p>
			<p id="ocultos" style="display:none;">
			</p>
			<input type="text" readonly name="Bono" value="true" style="display:none;">
			<input type="submit" value="Reservar">
		</form>
	</div>
	</div>
	
	<div id="bono">
	</div>
	

	<script>
	  function Infantil() {
		//muestro el boton que envia un formulario oculto con los datos para la ceracion del bono
		document.getElementById("bono").innerHTML = '<form id="miFormulario" method="" action="/Pr�ctica3/mvc/views/ClientViews/ReservarConNuevoBonoView.jsp">' + 
		'<input type="text" readonly name="Tipo" value="Infantil" style="display:none;">' + 
		'<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %> style="display:none;">' + 
		'<input type="submit" value="Nuevo Bono infantil"> </form>';
	   	
		//recojo esos datos para hacer una peticion get por si el usuario ya tiene un bono y quiere usarlo
		const formulario = document.getElementById('miFormulario');
	   	
	   	const searchParams = new URLSearchParams();
	   	searchParams.set('Tipo', formulario.elements.Tipo.value);
	   	searchParams.set('Email', formulario.elements.Email.value);
			   	  
	   	const url = "/Pr�ctica3/GetTieneBono?" + searchParams.toString();
		//console.log(url);
	   	fetch(url)
	      .then(response => response.text())
	      .then(data => { 
	    	  //const data = "true";
	    	  
	    	  if (data == "true"){
	    			document.getElementById("reservar").innerHTML = '<form><button href="#" onclick="visibilidad()">Reservar con tu Bono Infantil</button></form><br>';
	    	  }
	    	  else{
	    		  ocultar();
	    			document.getElementById("reservar").innerHTML = '<p class="botones" href="#">No tienes bonos infantiles</p><br>';
	    	  }
	    	
	  	});
	    return false;
	  }
	  function Familiar() {
			//muestro el boton que envia un formulario oculto con los datos para la ceracion del bono
			document.getElementById("bono").innerHTML = '<form id="miFormulario" method="" action="/Pr�ctica3/mvc/views/ClientViews/ReservarConNuevoBonoView.jsp">' + 
			'<input type="text" readonly name="Tipo" value="Familiar" style="display:none;">' + 
			'<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %> style="display:none;">' + 
			'<input type="submit" value="Nuevo Bono familiar"> </form>';
		   	
			//recojo esos datos para hacer una peticion get por si el usuario ya tiene un bono y quiere usarlo
			const formulario = document.getElementById('miFormulario');
		   	
		   	const searchParams = new URLSearchParams();
		   	searchParams.set('Tipo', formulario.elements.Tipo.value);
		   	searchParams.set('Email', formulario.elements.Email.value);
				   	  
		   	const url = "/Pr�ctica3/GetTieneBono?" + searchParams.toString();
			//console.log(url);
		   	fetch(url)
		      .then(response => response.text())
		      .then(data => { 
		    	  //const data = "true";
		    	  
		    	  if (data == "true"){
		    			document.getElementById("reservar").innerHTML = '<form><button href="#" onclick="visibilidad()">Reservar con tu Bono Familiar</button></form><br>';
		    	  }
		    	  else{
		    		  ocultar();
		    			document.getElementById("reservar").innerHTML = '<p class="botones" href="#">No tienes bonos familiares</p><br>';
		    	  }
		    	
		  	});
		    return false;
		  }
	  function Adulto() {
			//muestro el boton que envia un formulario oculto con los datos para la ceracion del bono
			document.getElementById("bono").innerHTML = '<form id="miFormulario" method="" action="/Pr�ctica3/mvc/views/ClientViews/ReservarConNuevoBonoView.jsp">' + 
			'<input type="text" readonly name="Tipo" value="Adulto" style="display:none;">' + 
			'<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %> style="display:none;">' + 
			'<input type="submit" value="Nuevo Bono adulto"> </form>';
		   	
			//recojo esos datos para hacer una peticion get por si el usuario ya tiene un bono y quiere usarlo
			const formulario = document.getElementById('miFormulario');
		   	
		   	const searchParams = new URLSearchParams();
		   	searchParams.set('Tipo', formulario.elements.Tipo.value);
		   	searchParams.set('Email', formulario.elements.Email.value);
				   	  
		   	const url = "/Pr�ctica3/GetTieneBono?" + searchParams.toString();
			//console.log(url);
		   	fetch(url)
		      .then(response => response.text())
		      .then(data => { 
		    	  //const data = "true";
		    	  
		    	  if (data == "true"){
		    			document.getElementById("reservar").innerHTML = '<form><button href="#" onclick="visibilidad()">Reservar con tu Bono Adulto</button></form><br>';
		    	  }
		    	  else{
		    		  ocultar();
		    			document.getElementById("reservar").innerHTML = '<p class="botones" href="#">No tienes bonos adultos</p><br>';
		    	  }
		    	
		  	});
		    return false;
		  }
	  
	  function visibilidad() {
		  	document.getElementById("visibilidad").style.display = "";
		  	document.getElementById("reservar").style.display = "none";	
	  }
	  
	  function ocultar() {
		  	document.getElementById("visibilidad").style.display = "none";
		  	document.getElementById("reservar").style.display = "";	
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
		   	
		    
		    var ParametrosVisibles = '<div class="field"><label for="Duracion">Duraci�n de la reserva: </label><input type="number" name="Duracion" required></div><br>';
			
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
		    
		    
		   	const url = "/Pr�ctica3/GetPistasDisponibles?" + searchParams.toString();
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