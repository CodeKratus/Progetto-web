<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista clienti</title>
</head>
<body>

	<%@page
		import="it.betacom.dao.ClientiDao,it.betacom.dao.PSUserDao,it.betacom.dao.LoginDao,it.betacom.bean.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<h1>Lista clienti</h1>
	<h1></h1>
	<%
	
	/*prendo la lista dei clienti e la stampo*/
	List<Clienti> list = ClientiDao.getAllRecords();
	request.setAttribute("list", list);
	%>

	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Citta</th>
			<th>Cellulare</th>
			<th>Indirizzo</th>
			<th>Animali Comprati</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getNome()}</td>
				<td>${u.getCognome()}</td>
				<td>${u.getCitta()}</td>
				<td>${u.getCellulare()}</td>
				<td>${u.getIndirizzo()}</td>
				<td><form action="animaliComprati.jsp?userId=${u.getId()}">
						<input type="hidden" name="userId" value="${u.getId()}">
						<button type="submit" value="Submit">Animali Comprati</button>
					</form>
			</tr>

		</c:forEach>
	<%--Uso il form per utilizzare i bottoni --%>
	</table>
	<form action="listaAnimali.jsp">
		<button type="submit">Vai lista Animali</button>
	</form>
	
	<form action= "login.jsp">
		<button type="submit">Logout</button>
	</form>


	<%
	/*Prendo il ruolo e controllo se è uguale a M di Manager ... se la condizione è vera
	mostro la stringa ed il link alla pagina di gestione utenti*/
	String a = (String) request.getAttribute("role");
	if (a.equals("M")) {
	%>
	<h2>
		Sei loggato come Manager
		</h2>
		<form action="listaUtenti.jsp">
		<button type="submit">Gestisci Utenti</button>
	    </form>
			<%}; 


%>
		
</body>
</html>