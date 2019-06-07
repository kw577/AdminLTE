<%@page import="proj.kw.dto.User"%>
<%@page import="proj.kw.dao.UserDAO"%>
<jsp:useBean id="user" class="proj.kw.dto.User"/>
<jsp:setProperty property="*" name="user"/>

<%





System.out.println("\n\n\n\ncheckRegistration page !!!");

System.out.println("\nNew user name: " + user.getName());
System.out.println("New user password: " + user.getPassword());
System.out.println("New user email: " + user.getEmail());

int result = UserDAO.addUser(user);

if(result == 1 ){
	response.sendRedirect("http://localhost:8080/AdminLTE/login");
}
else{
	response.sendRedirect("register.jsp");
}

%>