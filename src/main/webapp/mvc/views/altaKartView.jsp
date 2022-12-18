<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir un kart</title>
<link href="/Práctica3/mvc/views/formStyles.css" rel="stylesheet" type="text/css">
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
	<form method="post" action="/Práctica3/crearkart">
		<div class="field">
			<label for="Tipo">Tipo de kart: </label>
			<select name="Tipo" required>
				<option>Child</option>
				<option>Adult</option>
			</select>
		</div>
		<br/>
		<div class="field">
			<label for="Estado">Estado del kart: </label>
			<select name="Estado" required>
				<option>Disponible</option>
				<option>Mantenimiento</option>
				<option>Reservado</option>
			</select>
		</div>
		<br/>
		<input type="submit" value="Acceder">
	</form>
	</div>
</body>
</html>