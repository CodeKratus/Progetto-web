<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Utenti</title>
<link rel="shortcut icon" href="favicon.ico?" type="image/x-icon" />
</head>
<body>

	<%@page import="it.betacom.dao.PSUserDao,it.betacom.bean.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



	<h1>Lista Utenti</h1>
	<%
	List<PSUser> list = PSUserDao.getAllRecords();
	request.setAttribute("list", list);
    

	%>



	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Email</th>
			<th>Cellulare</th>
			<th>Password</th>
			<th>Ruolo</th>
			<th>Status</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getNome()}</td>
				<td>${u.getCognome()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getCellulare()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getRuolo()}</td>
				
				<%-- Passo l'id dello status cliccato --%>
				<td>${u.getStatus()} <form action="editStatus.jsp?id=${u.getId()}" method="post">
					<input type="submit" value="Cambia Status"/>
					</form></td>
				<td><a href="editUtenteForm.jsp?id=${u.getId()}">Modifica</a></td>
		</c:forEach>

	</table>

	
	<form action="addUtenteForm.jsp">
		<br/><button type="submit">Aggiungi un nuovo utente</button>
	</form>
	<form action="login.jsp">
		<button type="submit">Logout</button>
	</form>


</body>
</html>