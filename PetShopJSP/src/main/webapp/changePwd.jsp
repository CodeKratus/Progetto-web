<%@page import="it.betacom.dao.PSUserDao"%>
<jsp:useBean id="u" class="it.betacom.bean.PSUser"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

u.setChangePWD("N");
System.out.println(u.getChangePWD());
int i= PSUserDao.updPwd(u);

response.sendRedirect("login.jsp");
%>