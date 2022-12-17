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
	
	<div id="bono">
	</div>
	

	<script>
	  function Infantil() {
		//muestro el boton que envia un formulario oculto con los datos para la ceracion del bono
		document.getElementById("bono").innerHTML = '<form id="miFormulario" method="post" action="/Práctica3/PostCrearBono">' + 
		'<input type="text" readonly name="Tipo" value="infantil" style="display:none;">' + 
		'<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %> style="display:none;">' + 
		'<input type="submit" value="Nuevo Bono infantil"> </form>';
	   	
		//recojo esos datos para hacer una peticion get por si el usuario ya tiene un bono y quiere usarlo
		const formulario = document.getElementById('miFormulario');
	   	
	   	const searchParams = new URLSearchParams();
	   	searchParams.set('Tipo', formulario.elements.Tipo.value);
	   	searchParams.set('Email', formulario.elements.Email.value);
			   	  
	   	const url = "/Práctica3/GetTieneBono?" + searchParams.toString();
		//console.log(url);
	   	fetch(url)
	      .then(response => response.text())
	      .then(data => { 
	    	  //const data = "true";
	    	  
	    	  if ("true" == "true"){
	    			document.getElementById("reservar").innerHTML = '<form><button href="/Práctica3/mvc/views/ClientViews/ReservasBono/ReservaBonoInfantil.jsp">Reservar con tu Bono infantil</button></form><br>';
	    	  }
	    	  else{
	    			document.getElementById("reservar").innerHTML = '<p class="botones">No tienes bonos infantiles</p><br>';
	    	  }
	    	
	  	});
	    return false;
	  }
	  function Familiar() {
			//muestro el boton que envia un formulario oculto con los datos para la ceracion del bono
			document.getElementById("bono").innerHTML = '<form id="miFormulario" method="post" action="/Práctica3/PostCrearBono">' + 
			'<input type="text" readonly name="Tipo" value="familiar" style="display:none;">' + 
			'<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %> style="display:none;">' + 
			'<input type="submit" value="Nuevo Bono familiar"> </form>';
		   	
			//recojo esos datos para hacer una peticion get por si el usuario ya tiene un bono y quiere usarlo
			const formulario = document.getElementById('miFormulario');
		   	
		   	const searchParams = new URLSearchParams();
		   	searchParams.set('Tipo', formulario.elements.Tipo.value);
		   	searchParams.set('Email', formulario.elements.Email.value);
				   	  
		   	const url = "/Práctica3/GetTieneBono?" + searchParams.toString();
			//console.log(url);
		   	fetch(url)
		      .then(response => response.text())
		      .then(data => { 
		    	  //const data = "true";
		    	  
		    	  if (data == "true"){
		    			document.getElementById("reservar").innerHTML = '<form><button href="/Práctica3/mvc/views/ClientViews/ReservasBono/ReservaBonoFamiliar.jsp">Reservar con tu Bono familiar</button></form><br>';
		    	  }
		    	  else{
		    			document.getElementById("reservar").innerHTML = '<p class="botones">No tienes bonos familiares</p><br>';
		    	  }
		    	
		  	});
		    return false;
		  }
	  function Adulto() {
			//muestro el boton que envia un formulario oculto con los datos para la ceracion del bono
			document.getElementById("bono").innerHTML = '<form id="miFormulario" method="post" action="/Práctica3/PostCrearBono">' + 
			'<input type="text" readonly name="Tipo" value="infantil" style="display:none;">' + 
			'<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %> style="display:none;">' + 
			'<input type="submit" value="Nuevo Bono adulto"> </form>';
		   	
			//recojo esos datos para hacer una peticion get por si el usuario ya tiene un bono y quiere usarlo
			const formulario = document.getElementById('miFormulario');
		   	
		   	const searchParams = new URLSearchParams();
		   	searchParams.set('Tipo', formulario.elements.Tipo.value);
		   	searchParams.set('Email', formulario.elements.Email.value);
				   	  
		   	const url = "/Práctica3/GetTieneBono?" + searchParams.toString();
			//console.log(url);
		   	fetch(url)
		      .then(response => response.text())
		      .then(data => { 
		    	  //const data = "true";
		    	  
		    	  if (data == "true"){
		    			document.getElementById("reservar").innerHTML = '<form><button href="/Práctica3/mvc/views/ClientViews/ReservasBono/ReservaBonoAdulto.jsp">Reservar con tu Bono adulto</button></form><br>';
		    	  }
		    	  else{
		    			document.getElementById("reservar").innerHTML = '<p class="botones">No tienes bonos adultos</p><br>';
		    	  }
		    	
		  	});
		    return false;
		  }
	</script>
    
</body>
</html>