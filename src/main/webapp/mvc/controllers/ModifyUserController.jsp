<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="usuario" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%@ page import="data.dao.UsuarioDAO" %>
<%@ page import="business.UsuarioDTO" %>
<%@ page import="data.common.SystemManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificando</title>
</head>
<body>
	<% 
		String nextPage = "../views/ModifyAdminView.jsp";
		String nextPageMessage = null;
		
		String opcion = request.getParameter("menu");
		String valor = request.getParameter("nuevo");
		String email = request.getParameter("email");
	%>
	<%
		UsuarioDTO user = UsuarioDAO.getUser(email);
		if(user != null){
			if(opcion.equals("Nombre")){
				user.setNameSurname(valor);
				UsuarioDAO.modNameUser(user);
				nextPage = "../../index.jsp";
			}
			else if(opcion.equals("Password")){
				user.setPassword(valor);
				UsuarioDAO.modPassUser(user);
				nextPage = "../../index.jsp";
			}
			else if(opcion.equals("Fecha de nacimiento (format DD-MM-YYYY)")){
				valor = valor + " 00:00:00";
				user.setBirthDate(SystemManager.StringToDateSQL(valor));
				UsuarioDAO.modBirhtUser(user);
				nextPage = "../../index.jsp";
			}
			else if(opcion.equals("Rol (\"Administrador\" o \"Cliente\")")){
				if(valor.equals("Cliente") || valor.equals("Administrador")){
					user.setRol(valor);
					UsuarioDAO.modRolUser(user);
					nextPage = "../../index.jsp";
				}else{
					
				}
				nextPageMessage = "ERROR. Rol introducido incorrecto. Puede ser Cliente o Administrador";
	%>
				<jsp:forward page="<%=nextPage%>">
		    		<jsp:param name="error" value="<%=nextPageMessage%>"/>
				</jsp:forward>
	<%
			}
	%>
			<jsp:forward page="<%=nextPage%>" />
	<%
		}else{ 
			nextPageMessage = "ERROR. El Email introducido no se encuentra en la base de datos.";
	%>
			<jsp:forward page="<%=nextPage%>">
	    		<jsp:param name="error" value="<%=nextPageMessage%>"/>
			</jsp:forward>
	<%
		}
		
	%>
</body>
</html>