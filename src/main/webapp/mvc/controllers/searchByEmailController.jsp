<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="User" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
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
		
		String mail = request.getParameter("email");

	
		if(UsuarioDAO.comprobarEsxistenciaUsuario(mail) == true) {
			nextPage = "../views/ModifyAdminView.jsp";
			nextPageMessage = "";
	%>
	<!-- si descomentamos esto no funciona, creo que es porque el bean no funciona -->
	<%-- <jsp:setProperty property="mail" value="<%=mail%>" name="User"/> --%>
	<%
		} else if(mail != null) { 
			nextPageMessage = "error";
	%>
	
	<%
		} else {
	%>
	<jsp:setProperty property="email" value="" name="User"/>
	<%
		}
	%>
</body>
</html>
<%
	if(mail != null) {
%>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
</jsp:forward>
<%
	} else {
%>
<jsp:forward page="<%=nextPage%>" />
<% 
	}
%>