<%@page import="it.betacom.dao.PSUserDao,it.betacom.bean.PSUser"%> 

<% 
/*
Ricevo l'id e lo cambio in base al valore che mi arriva dallo status*/
String id=request.getParameter("id");
PSUser a = PSUserDao.getRecordById(Integer.parseInt(id));



if(a.getStatus().contains("A")){
 a.setStatus("D");
 int i = PSUserDao.upS(a);}
 else{
	 a.setStatus("A");
	 int i = PSUserDao.upS(a);
 }



response.sendRedirect("listaUtenti.jsp");
%>

