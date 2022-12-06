<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<jsp:useBean id="usuario" class="display.javabean.CustomerBean" scope="session"/>
<%@ page import="data.dao.UsuarioDAO" %>
<%@ page import="business.UsuarioDTO" %>
<%@ page import="java.util.ArrayList" %>
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
		<h2>acceder al sistema</h2>
		<a href="/Práctica3/mvc/views/LoginView.jsp">Acceder</a>
		<a href="/Práctica3/mvc/views/RegisterView.jsp">Registrarse</a>
	</div>
	
	<% }
	else if(usuario.getRol().equals("Administrador")) { 
	%>
		<div class="container">
		<h1>Estás logueado como: "Administrador"</h1>
		<p>¡Bienvenido <%out.println(usuario.getUsuario()); %></p>
		
		<p>Hoy es <%out.println(java.time.LocalDate.now()); %></p>
		<h2>Listado de clientes:</h2>
		<table class="default">
  		<tr>
  			<th>Nombre</th>
    		<th>Antigüedad</th>
    		<th>Número de reservas</th>
 		</tr>
		<% ArrayList<UsuarioDTO> users = UsuarioDAO.listarUsuarios(); 
		for(int i=0;i<users.size();i++){%>
		  <tr>
    		<td><%out.println(users.get(i).getNameSurname()); %></td>
    		<td><%out.println(UsuarioDAO.calcularAntiguedad(users.get(i).getEmail())); %></td>
    		<td><%out.println(UsuarioDAO.getNReservas(users.get(i).getEmail())); %></td>
  		</tr>
		
		<%} %>
	</div>
	<% }
	else if(usuario.getRol().equals("Cliente")){
	%>
	
		<div class="container">
		<p>¡Bienvenido <%out.println(usuario.getUsuario()); %>!</p>
	
		<p>Hoy es <%out.println(java.time.LocalDate.now()); %></p>
		<p>Su antigüedad es de: <%out.println(UsuarioDAO.calcularAntiguedad(usuario.getUsuario())); %></p>
		<p>Su próxima reserva es el: <%out.println(UsuarioDAO.getProximaReserva(usuario.getUsuario())); %></p>
		
		<a href="/Práctica3/mvc/controllers/disconnectController.jsp">Desconectar</a>
		<a href="/Práctica3/mvc/views/ModifyAdminView.jsp">Modificar Datos</a>
	</div>
	
	<%
	}
	else{
		%>
		<a href="/Práctica3/mvc/controller/disconnectController.jsp">Desconectar</a>
		<a href="/Práctica3/mvc/views/SearchByEmailView.jsp">Modificar Datos</a>
	<%
	}
	%>
	
</body>
</html>