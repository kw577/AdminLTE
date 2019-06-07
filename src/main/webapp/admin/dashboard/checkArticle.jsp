<%@page import="proj.kw.dto.Article"%>
<%@page import="proj.kw.dao.ArticleDAO"%>
<jsp:useBean id="article" class="proj.kw.dto.Article"/>
<jsp:setProperty property="*" name="article"/>

<%





System.out.println("\n\n\n\ncheckRegistration page !!!");

System.out.println("\nArticle Id: " + article.getTitle());
System.out.println("Author: " + article.getAuthor());
System.out.println("Desription: " + article.getDescription());



int result = ArticleDAO.addArticle(article);

if(result == 1 ){
	response.sendRedirect("http://localhost:8080/AdminLTE/");
}
else{
	response.sendRedirect("${pageContext.request.contextPath }/admin/dashboard/newArticle.jsp");
}

%>