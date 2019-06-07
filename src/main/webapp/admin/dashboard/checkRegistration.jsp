<%@page import="proj.kw.dto.User"%>
<jsp:useBean id="user" class="proj.kw.dto.User"/>
<jsp:setProperty property="*" name="user"/>

<%





System.out.println("\n\n\n\ncheckRegistration page !!!");

System.out.println("\nNew user name: " + user.getName());
System.out.println("New user password: " + user.getPassword());
System.out.println("New user email: " + user.getEmail());



%>