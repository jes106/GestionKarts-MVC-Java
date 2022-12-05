<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%@ page import="business.UsuarioDTO" %>
<%@ page import="data.dao.UsuarioDAO" %>
<%@ page import="data.common.SystemManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loading...</title>
</head>
<body>
	<%
		String nextPage = "../views/LoginView.jsp";
		String nextPageMessage = null;
		
		String mail = request.getParameter("email");
		String password = request.getParameter("password");

	
		if(UsuarioDAO.comprobarEsxistenciaUsuario(mail) == true) {
			nextPage = "../../index.jsp";
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