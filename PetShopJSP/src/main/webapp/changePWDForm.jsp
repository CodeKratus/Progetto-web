<%@page import="it.betacom.dao.PSUserDao,it.betacom.bean.PSUser"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>E' il tuo primo login ... hai bisogno di cambiare la password temporanea con una definitiva</h1>
<h1>Edit Form</h1>
<%
int a =  (Integer)request.getAttribute("id");
PSUser u=PSUserDao.getRecordById(a);
%>
<form action="changePwd.jsp" method="post"> 
<input type="hidden" name="id" value="<%=u.getId() %>"/>
<table>
<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Aggiorna Utente"/></td></tr>
</table>
</form>
 </div>
</body>
</html>