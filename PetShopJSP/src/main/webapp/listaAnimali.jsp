<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista animali</title>
<link rel="shortcut icon" href="favicon.ico?" type="image/x-icon" />
</head>
<body>

<%@page import="it.betacom.dao.AnimaliDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<h1>Lista animali</h1>

<%
List<Animali> list=AnimaliDao.getAllRecords();
request.setAttribute("list",list);
%>

<table border="1" width="90%">
<tr><th>Id</th><th>TipoAnimale</th><th>Matricola</th><th>Nome</th><th>Data_Acquisto</th><th>Prezzo</th><th>Id_Clienti</th></tr>
<c:forEach items="${list}" var="u">
	<tr><td>${u.getId()}</td><td>${u.getTipoAnimale()}</td><td>${u.getMatricola()}</td><td>${u.getNome()}</td><td>${u.getDataAcquisto()}</td><td>${u.getPrezzo()}</td><td>${u.getIdC()}</td></tr>
</c:forEach>
</table>
 <input type="button" value="Ritorna ai clienti" onclick="history.back()">




</body>
</html>