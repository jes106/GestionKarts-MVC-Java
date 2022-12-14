<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
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
	<div class="note-form">
	<form method="post" action="RUTA DEL POST">
		<div class="field">
			<label for="Nombre">Nombre: </label>
			<input type="text" name="Nombre" value="" required>	
		</div>
		<br/>
		<div class="field">
			<label for="Estado">Estado de la pista: </label>
			<select name="Estado" required>
				<option>Disponible</option>
				<option>Mantenimiento</option>
			</select>
		</div>
		<br/>
		<div class="field">
			<label for="Dificultad">Dificultad de la pista: </label>
			<select name="Dificultad" required>
				<option>Infantil</option>
				<option>Familiar</option>
				<option>Adultos</option>
			</select>
		</div>
		<br/>
		<div class="field">
			<label for="Max">Nº Maximo de Karts: </label>
			<input type="number" name="Max" required>

		</div>
		<br/>
		<input type="submit" value="Acceder">
	</form>
	</div>
</body>
</html>