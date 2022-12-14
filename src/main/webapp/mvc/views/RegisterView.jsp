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
	<form method="post" action="../controllers/registerController.jsp">
		<div class="field">
		<label for="name">Nombre y apellidos: </label>
		<input type="text" name="name" value="">	
		</div>
		<br/>
		<div class="field">
		<label for="date">fecha de nacimiento: </label>
		<input type="date" name="date" value="">
		</div>
		<div class="field">
		<label for="email">Email: </label>
		<input type="text" name="email" value="">	
		</div>
		<br/>
		<div class="field">
		<label for="password">Contraseña: </label>
		<input type="password" name="password" value="">	
		</div>
		<br/>
		<div class="field">
		<label for="rol">Rol: </label>
		<input type="text" readonly name="rol" value="Cliente">
		</div>
		<br />
		<input type="submit" value="Acceder">
	</form>
	</div>
</body>
</html>