<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="usuario" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Usuario</title>
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
	
	<% String persona = "-- Seleccione --"; %>
	<% if(request.getParameter("persona") != null){ persona = request.getParameter("persona"); } %>
	
	<% if(usuario != null && usuario.getRol().equals("Cliente")) { %>
			<div class="note-form">
			<form method="post" action="../controllers/ModifyUserController.jsp">
				<div class="field">
					<p style="display:none;">
					<input type="text" readonly name="email" value=<%= usuario.getUsuario() %>>
					</p>
					
					<label for="email">Parámetro a modificar:</label>
					<select name="menu" required>
		  				<option>Nombre</option>
		  				<option>Password</option>
		  				<option>Fecha de nacimiento (format DD-MM-YYYY)</option>
					</select>
					
					<label for="nuevo">Nuevo parámetro: </label>
					<input type="text" name="nuevo" value="" required>
				</div>
				<br /><input type="submit" value="Acceder">
			</form>
			</div>
	<% } %>
		
</body>
</html>