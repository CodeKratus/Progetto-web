<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crea un nuovo utente</title>
</head>
<body>

<h1>Crea un nuovo utente</h1>
<form action="addUtente.jsp" method="post"> 

<table>
<tr><td>Nome:</td><td><input type="text" name="nome"/></td></tr>
<tr><td>Cognome:</td><td><input type="text" name="cognome"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
<tr><td>Cellulare:</td><td><input type="text" name="cellulare"/></td></tr>
<tr><td>Password temporanea:</td><td><input type="password" name="password"/></td></tr> 
<tr><td>Ruolo:</td><td><input type="radio" name="ruolo" value="M"/>Manager <input type="radio" name="ruolo" value="G"/>Guest </td></tr>
<tr><td>Status:</td><td><input type="radio" name="status" value="A"/>Attivo <input type="radio" name="status" value="D"/>Disattivo </td></tr>
<tr><td colspan="2"><input type="submit" value="Aggiungi Utente"/></td></tr>
</table>
</form>

</body>
</html>