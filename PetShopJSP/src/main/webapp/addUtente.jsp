<%@page import="it.betacom.dao.PSUserDao,it.betacom.bean.PSUser"%>
<jsp:useBean id="u" class="it.betacom.bean.PSUser"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>


<%

int i=PSUserDao.save(u);
response.sendRedirect("listaUtenti.jsp");


%>