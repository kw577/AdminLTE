package proj.kw.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proj.kw.dto.Article;
import proj.kw.dto.User;

public class ArticleDAO {
  private static Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_lte", "root", "");

    } catch (Exception e) {
      System.out.println(e);
    }
    return con;
  }

  
  public static int addArticle(Article article) {
	    int status = 0;
	    try {
	      Connection con = getConnection();
	      PreparedStatement stmt = con.prepareStatement("insert into articles (title,author,description) values (?,?,?)");
	      stmt.setString(1, article.getTitle());
	      stmt.setString(2, article.getAuthor());
	      stmt.setString(3, article.getDescription());
	      status = stmt.executeUpdate();
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	    return status;
	  }
  
  
}
