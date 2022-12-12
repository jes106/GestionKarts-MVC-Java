<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="usuario" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
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
			if(UsuarioDAO.comprobarPassword(mail, password) == true) {
				nextPage = "../../index.jsp";
				nextPageMessage = "";
				usuario.setUsuario(mail);
				usuario.setRol(UsuarioDAO.getRole(mail));
			}
			/* else {
				System.out.println("contraseña incorrecta!");
			} */
		} else if(mail != null) { 
			nextPageMessage = "Error: email o password incorrectos";

		} %>
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