<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<p class="red-text">ERROR: el Email no pertenece a ningun usario!</p>
	<%
		}
	%>
	<div class="note-form">
	<form method="post" action="../controllers/ModifyUserController.jsp">
		<div class="field">
			<label for="email">Parámetro a modificar:</label>
			<select name="menu">
  				<option>Fecha de nacimiento (fomrma DD-MM-YYY)</option>
				<option>Nombre</option>
				<option>Rol ("Administrador" o "cliente")</option>
			</select>
			<label for="email">Nuevo parámetro: </label>
			<input type="text" name="nuevo" value="">
		</div>
		<br />
		<input type="submit" value="Acceder">
	</form>
	</div>
</body>
</html>