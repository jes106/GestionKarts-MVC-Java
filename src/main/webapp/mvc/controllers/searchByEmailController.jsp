<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="User" scope="session" class="display.javabean.NewCustomerBean"></jsp:useBean>
<%@ page import="data.dao.UsuarioDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busqueda por email</title>
</head>
<body>
	<%
		String nextPage = "../views/SearchByEmailView.jsp";
		String nextPageMessage = null;
	
		String email = request.getParameter("email");
		
		if(UsuarioDAO.comprobarEsxistenciaUsuario(email) == true) {
			nextPage = "../views/ModifyAdminView.jsp";
			nextPageMessage = "";
	%>
	<jsp:setProperty property="mail" value="<%=email	%>" name="User"/>
	<%
		} 
		else { 
			nextPageMessage = "error";
	%>
	<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
	</jsp:forward>
	<% 
		}
	%>
	
</body>
</html>