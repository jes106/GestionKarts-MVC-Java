<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="usuario" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Reservas</title>
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
		    <h2>Introduce el intervalo de fechas para la reserva</h2>
			<div class="field">
				<label for="StartDate">Fecha Inicial: </label>
				<input type="date" name="StartDate" value="" required>
				<input type="time" name="StartTime" value="" required>
			</div>
			<br/>
			<div class="field">
				<label for="EndDate">Fecha Final: </label>
				<input type="date" name="EndDate" value="" required>
				<input type="time" name="EndTime" value="" required>
			</div>
			<p style="display:none;">
			<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %>>
			</p>
			<br />
			<button type="submit">Consultar Reservas</button>
			<br />
			<table id="output">
				<tr>
					<th><p>Fecha y Hora</p></th>
					<th><p>Precio</p></th>
					<th><p>Pista</p></th>
					<th><p>Tipo</p></th>
					<th><p>Menores</p></th>
					<th><p>Adultos</p></th>
					<th><p>Estado</p></th>
				</tr>
			</table>
			<div id="noReservas" style="color:red;"></div>
		</form>
	</div>

	<script>
	  function peticion() {
		const formulario = document.getElementById('miFormulario');
	   	
	   	const searchParams = new URLSearchParams();
	   	searchParams.set('StartDate', formulario.elements.StartDate.value);
	   	searchParams.set('StartTime', formulario.elements.StartTime.value);
	   	searchParams.set('EndDate', formulario.elements.EndDate.value);
	   	searchParams.set('EndTime', formulario.elements.EndTime.value);
	   	searchParams.set('Email', formulario.elements.Email.value);
	   	  
	   	const url = "/Práctica3/GetConsultarReservas?" + searchParams.toString();
		//console.log(url);
	   	fetch(url)
	      .then(response => response.text())
	      .then(data => {
	    	  if(data == ''){
		        	document.getElementById("noReservas").innerHTML = "No hay Pistas con estas características"
		        }
	    	  
	    	  const dataWithoutNewLines = data.replace(/\n/g, '');
	    	  const rows = dataWithoutNewLines.split('//'); // dividir el texto en filas

	    	/* // Crear una tabla HTML
	    	const table = document.createElement('table'); */

	    	// Para cada fila de datos...
	    	rows.forEach(row => {
	    	  // Dividir la fila en columnas
	    	  const columns = row.split(',');

	    	  // Crear una fila de tabla
	    	  const tableRow = document.createElement('tr');

	    	  // Para cada columna...
	    	  columns.forEach(column => {
	    	    // Crear una celda de tabla
	    	    const tableCell = document.createElement('td');
	    	    // Establecer el contenido de la celda
	    	    const cellContent = column.replace(/\n/g, '');
				tableCell.innerHTML = "<p>" + cellContent + "</p>";
	    	    // Añadir la celda a la fila
	    	    tableRow.appendChild(tableCell);
	    	  });

	    	  // Añadir la fila a la tabla
	    	  document.getElementById('output').appendChild(tableRow);
	    	});

	    	// Añadir la tabla al documento HTML
	    	document.getElementById('output').appendChild(table);
			  //document.getElementById('output').innerHTML = data;
	  	});
	    return false;
	  }
	</script>
    
</body>
</html>