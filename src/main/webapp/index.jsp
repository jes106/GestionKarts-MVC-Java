<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<jsp:useBean id="usuario" class="display.javabean.CustomerBean" scope="session"/>
<%@ page import="data.dao.UsuarioDAO" %>
<%@ page import="business.UsuarioDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserva de Karts</title>
<link href="/Práctica3/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

	
	<% 
	String nextPage="";
	if(usuario.getUsuario() == null){ 
	%>
	
		<div class="container">
		<h1>Aplicacion de Karts</h1>
		<h2>Acceder al sistema</h2>
		<div class="botones">
			<a href="/Práctica3/mvc/views/LoginView.jsp">Acceder</a>
			<a href="/Práctica3/mvc/views/RegisterView.jsp">Registrarse</a>
		</div>
	</div>
	
	<% }
	else if(usuario.getRol().equals("Administrador")) { 
	%>
		<div class="container">
			<div class="info">
				<h2>Bienvenido Administrador: <%out.println(usuario.getUsuario());%></h2>
				<h2>Hoy es <%out.println(java.time.LocalDate.now());%></h2>
			</div>
		<div class="botones">
			<a href="/Práctica3/mvc/controllers/disconnectController.jsp">Desconectar</a>
			<a href="/Práctica3/mvc/views/ModifyAdminView.jsp">Modificar Datos</a>
			<a href="/Práctica3/mvc/views/RegisterAdminView.jsp">Registrar usuario</a>
			<a href="/Práctica3/crearkart?rol=Administrador">Añadir Kart</a>
			<a href="/Práctica3/creartrack?rol=Administrador">Añadir Pista</a>
			<a href="/Práctica3/asociarkartpistas?rol=Administrador">Asociar Kart-Pista</a>
			<a href="/Práctica3/ManejadorModifyKart?rol=Administrador">Modificar Kart</a>
			<a href="/Práctica3/ManejadorModifyTrack?rol=Administrador">Modificar Pista</a>
			<a href="/Práctica3/ManejadorDeleteReservation?rol=Administrador">Eliminar Reserva</a>
			
		</div>
		<h2>Listado de clientes:</h2>
		<table class="default">
	  		<tr>
	  			<th><h2>Nombre</h2></th>
	    		<th><h2>Antigüedad</h2></th>
	    		<th><h2>Nº Reservas</h2></th>
	 		</tr>
			<% ArrayList<UsuarioDTO> users = UsuarioDAO.listarUsuarios(); 
			ArrayList<Integer> ant = UsuarioDAO.calcularAntiguedadArray();
			ArrayList<Integer> res = UsuarioDAO.getNReservasArr();
			for(int i=0;i<users.size();i++){%>
			<tr>
	    		<td><%out.println(users.get(i).getNameSurname()); %></td>
	    		<td><%out.println(ant.get(i)); %></td>
	    		<td><%out.println(res.get(i)); %></td>
  			</tr>		
		<%} %>
		</table>
		

	</div>
	<% }
	else if(usuario.getRol().equals("Cliente")){
	%>
		<% Timestamp res = UsuarioDAO.getProximaReserva(usuario.getUsuario()); %>
		<div class="container">
			<div class="info">
				<h2>Bienvenido <%out.println(usuario.getUsuario()); %>!</h2>
				<h2>Hoy es <%out.println(java.time.LocalDate.now()); %></h2>
				<h2>Su antigüedad es de: <%out.println(UsuarioDAO.calcularAntiguedad(usuario.getUsuario())); %> años</h2>
			</div>
			<% if(res == null) { %>
				<p>Su próxima reserva es el: No tiene reservas.</p>
			<% }else { %>
				<p>Su próxima reserva es el: <%out.println(UsuarioDAO.getProximaReserva(usuario.getUsuario())); %></p>
			<% } %>
			<div class="botones">
				<a href="/Práctica3/mvc/controllers/disconnectController.jsp">Desconectar</a>
				<a href="/Práctica3/mvc/views/ModifyClientView.jsp">Modificar mis datos</a>
				<a href="/Práctica3/mvc/views/ClientViews/GetReservationsWithDateIntervalView.jsp">Consultar Reservas</a>
				<a href="/Práctica3/mvc/views/ClientViews/MakeIndividualReservation.jsp">Reserva Individual</a>
				<a href="/Práctica3/mvc/views/ClientViews/MenuBonoView.jsp">Reserva con Bono</a>
				<a href="/Práctica3/mvc/views/ClientViews/DeleteClientReservationView.jsp">Eliminar Reserva</a>
			</div>
		</div>
	
	<%
	}
	else{
		%>
		<div class="botones">
			<a href="/Práctica3/mvc/controller/disconnectController.jsp">Desconectar</a>
			<a href="/Práctica3/mvc/views/ModifyClientView.jsp">Modificar Datos</a>
		</div>
	<%
	}
	%>
	
</body>
</html>