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
<link href="/Pr�ctica3/styles.css" rel="stylesheet" type="text/css">
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
			<a href="/Pr�ctica3/mvc/views/LoginView.jsp">Acceder</a>
			<a href="/Pr�ctica3/mvc/views/RegisterView.jsp">Registrarse</a>
		</div>
	</div>
	
	<% }
	else if(usuario.getRol().equals("Administrador")) { 
	%>
		<div class="container">
			<div class="info">
				<p>Est�s logueado como: "Administrador"</p>
				<p>Bienvenido <%out.println(usuario.getUsuario()); %></p>
				<p>Hoy es <%out.println(java.time.LocalDate.now()); %></p>
			</div>
		<div class="botones">
			<a href="/Pr�ctica3/mvc/controllers/disconnectController.jsp">Desconectar</a>
			<a href="/Pr�ctica3/mvc/views/ModifyAdminView.jsp">Modificar Datos</a>
			<a href="/Pr�ctica3/mvc/views/RegisterAdminView.jsp">Registrar usuario</a>
		</div>
		<h2>Listado de clientes:</h2>
		<table class="default">
	  		<tr>
	  			<th>Nombre</th>
	    		<th>Antig�edad</th>
	    		<th>N�mero de reservas</th>
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
				<p>Bienvenido <%out.println(usuario.getUsuario()); %>!</p>
				<p>Hoy es <%out.println(java.time.LocalDate.now()); %></p>
				<p>Su antig�edad es de: <%out.println(UsuarioDAO.calcularAntiguedad(usuario.getUsuario())); %></p>
			</div>
			<% if(res == null) { %>
				<p>Su pr�xima reserva es el: No tiene reservas.</p>
			<% }else { %>
				<p>Su pr�xima reserva es el: <%out.println(UsuarioDAO.getProximaReserva(usuario.getUsuario())); %></p>
			<% } %>
			<a href="/Pr�ctica3/mvc/controllers/disconnectController.jsp">Desconectar</a>
			<a href="/Pr�ctica3/mvc/views/ModifyClientView.jsp">Modificar Datos</a>
		</div>
	
	<%
	}
	else{
		%>
		<div class="botones">
			<a href="/Pr�ctica3/mvc/controller/disconnectController.jsp">Desconectar</a>
			<a href="/Pr�ctica3/mvc/views/ModifyClientView.jsp">Modificar Datos</a>
		</div>
	<%
	}
	%>
	
</body>
</html>