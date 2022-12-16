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
		<form id="miFormulario">
		    <h2>Introduce el intervalo de fechas para la reserva</h2>
			<div class="field">
				<label for="StartDate">Fecha Inicial: </label>
				<input type="date" name="StartDate" value="" required>
			</div>
			<br/>
			<div class="field">
				<label for="EndDate">Fecha Final: </label>
				<input type="date" name="EndDate" value="" required>
			</div>
			<p style="display:none;">
			<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %>>
			</p>
			<br />
			<input type="submit" value="Consultar Reservas">
		
		<div id="respuesta"> aquí irá la respuesta del get</div>
		
		</form>
	</div>
	
	
    <script>
    const formulario = document.getElementById('miFormulario');
    
    formulario.addEventListener('submit', e => {
        e.preventDefault();

        const StartDate = formulario.elements.StartDate.value;
        const EndDate = formulario.elements.EndDate.value;
        const Email = formulario.elements.Email.value;

        fetch(`/Práctica3/GetConsultarReservas?StartDate=${StartDate}&EndDate=${EndDate}&Email=${Email}`)
          .then(response => response.text())
          .then(html => {
            const contenedor = document.getElementById('respuesta');
            contenedor.innerHTML = html;
          })
          .catch(error => console.error(error));
      });

    } 
    </script>
</body>
</html>