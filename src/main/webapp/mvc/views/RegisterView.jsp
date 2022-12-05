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
	<p class="red-text">ERROR: no se ha registrado!</p>
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
		<label for="day">día nacimiento (forma DD): </label>
		<input type="text" name="day" value="">
		</div>
		<br/>
		<div class="field">
		<label for="month">mes nacimiento (fomra MM): </label>
		<input type="text" name="month" value="">	
		</div>
		<br/>
		<div class="field">
		<label for="year">año nacimiento (fomra YYYY): </label>
		<input type="text" name="year" value="">	
		</div>
		<br/>
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
		<input type="text" name="rol" value="">
		</div>
		<br />
		<input type="submit" value="Acceder">
	</form>
	</div>
</body>
</html>