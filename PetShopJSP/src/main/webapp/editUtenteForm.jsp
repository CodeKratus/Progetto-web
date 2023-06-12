<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica utente</title>
</head>
<body>
<%@page import="it.betacom.dao.PSUserDao,it.betacom.bean.PSUser"%>

<% 
String id=request.getParameter("id");
PSUser u=PSUserDao.getRecordById(Integer.parseInt(id));
%>

<h1>Modifica utente</h1>
<form action="editUtente.jsp" method="post"> 
<input type="hidden" name="id" value="<%=u.getId() %>"/>
<table>
<tr><td>Nome:</td><td><input type="text" name="nome"/></td></tr>
<tr><td>Cognome:</td><td><input type="text" name="cognome"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
<tr><td>Cellulare:</td><td><input type="text" name="cellulare"/></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
<tr><td>Ruolo:</td><td><input type="radio" name="ruolo" value="M"/>Manager <input type="radio" name="ruolo" value="G"/>Guest </td></tr>
<tr><td>Status:</td><td><input type="radio" name="status" value="A"/>Attivo <input type="radio" name="status" value="D"/>Disattivo </td></tr>
<tr><td colspan="2"><input type="submit" value="Aggiorna Utente"/></td></tr>
</table>
</form>

</body>
</html>