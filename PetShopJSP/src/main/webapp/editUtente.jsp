<%@page import="it.betacom.dao.PSUserDao"%>
<jsp:useBean id="u" class="it.betacom.bean.PSUser"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%


int i= PSUserDao.update(u);
response.sendRedirect("listaUtenti.jsp");
%>