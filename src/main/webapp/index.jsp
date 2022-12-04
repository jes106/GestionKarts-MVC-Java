<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserva de Karts</title>
<link href="/Pr�ctica3/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<!-- AQUI NECESITAMOS QUE FUNCIONE EL JAVA BEAM -->
	<!-- para diferenciar si el usuario es cliente o administrador o no ha iniciado sesion  --> -->
	
	
	<!--Aqui tenemos que comprobar si no ha iniciado sesion. -->
	<!-- entonces se le muestra la pagina de inicio 	-->
	<%-- <%
		String error = (String)request.getParameter("error");
		if(request.getParameter("disconnect") != null) {
	%>
	<jsp:setProperty property="mail" value="" name="User"/>
	<%
		}
		if(User.getMail() == "" || User.getMail() == null) {
	%> --%>

	<div class="container">
		<h1>Aplicacion de Karts</h1>
		<h2>acceder al sistema</h2>
		<a href="/Pr�ctica3/mvc/views/LoginView.jsp">Acceder</a>
		<a href="/Pr�ctica3/mvc/views/RegisterView.jsp">Registrarse</a>
	</div>
	
	<!-- Aqui tenemos que comprobar es cliente. -->
	<!-- entonces se le muestra la pagina de cliente -->
	<%-- <% else if(user.getRol() == "Cliente") { %> --%>
	
	<div class="container">
		<h1>Cuando el JavaBeam funcione esto solo se le mostrara si est� logueado como "Cliente"</h1>
		<p>�Bienvenido (aqu� pondr� el nombre)<%-- <%out.println(user.getNameSurname()); %> --%>!</p>
		
		<p>Hoy es <%out.println(java.time.LocalDate.now()); %></p>
		<p>Se registr� el d�a (aqu� pondr� la fecha)<%-- <%out.println(formattedRegisterDate); %> --%></p>
		
		<a href="/Pr�ctica3/mvc/controllers/DisconnectController.jsp">Desconectar</a>
		<a href="/Pr�ctica3/mvc/views/ModifyClienteView.jsp">Modificar Datos</a>
	</div>
	
	<%-- <%
	} 
	else if(user.getRole() == "Administrador") { 
	%> --%>
	
	<div class="container">
		<h1>Cuando el JavaBeam funcione esto solo se le mostrara si est� logueado como "Administrador"</h1>
		<p>�Bienvenido (aqu� pondr� el nombre)<%-- <%out.println(user.getNameSurname()); %> --%>!</p>
		
		<p>Hoy es <%out.println(java.time.LocalDate.now()); %></p>
		<h2>Listado de clientes:</h2>
		
		<a href="/Pr�ctica3/mvc/controllers/DisconnectController.jsp">Desconectar</a>
		<a href="/Pr�ctica3/mvc/views/SearchByEmailView.jsp">Modificar Datos</a>
	</div>
	
	<%-- <%
	} 
	%> --%>
</body>
</html>