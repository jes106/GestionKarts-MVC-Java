<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceder</title>
<link href="../views/formStyles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		if(request.getParameter("error") != null) {
	%>
	<p class="red-text">ERROR: no se ha logueado!</p>
	<%
		}
	%>
	<div class="note-form">
	<form method="post" action="../controllers/loginController.jsp">
		<div class="field">
		<label for="email">Email: </label>
		<input type="text" name="email" value="">
		</div>	
		<br />
		<input type="submit" value="Acceder">
	</form>
	</div>
</body>
</html>