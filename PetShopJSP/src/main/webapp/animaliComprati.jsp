<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animali comprati</title>
<link rel="shortcut icon" href="favicon.ico?" type="image/x-icon" />
</head>
<body>
<%@page import="it.betacom.dao.ClientiDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Animali comprati</h1>
 <%
int a = Integer.parseInt((String)request.getParameter("userId"));
List<Animali> list=ClientiDao.getAllComp(a);
request.setAttribute("list",list); 
%>

<table border="1" width="90%">
<tr><th>Id</th><th>TipoAnimale</th><th>Matricola</th><th>Nome</th><th>Data_Acquisto</th><th>Id_Clienti</th></tr>
<c:forEach items="${list}" var="u">
	<tr><td>${u.getId()}</td>
	<td>${u.getTipoAnimale()}</td>
	<td>${u.getMatricola()}</td>
	<td>${u.getNome()}</td>
	<td>${u.getDataAcquisto()}</td>
	<td>${u.getIdC()}</td>
</c:forEach>
</table>

 <input type="button" value="Ritorna ai clienti" onclick="history.back()">
 
</body>
</html>