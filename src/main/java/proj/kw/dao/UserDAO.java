package proj.kw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proj.kw.dto.User;

public class UserDAO {
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

  //wybiera uzytkonikow nie bedacych adminami
  public static List<User> getUsers() 
  {
    ResultSet resultSet = null;

    try 
    {
      Connection con = getConnection();
      PreparedStatement stmt = con.prepareStatement("select * from USER where role='user'");
      resultSet = stmt.executeQuery();
    } 
    catch (Exception e) 
    {
      System.out.println(e);
    }
    List<User> li = new ArrayList<User>();

    try 
    {
      while (resultSet.next()) 
      {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setName(resultSet.getString(2));
        user.setEmail(resultSet.getString(4));
        li.add(user);
      }
    } 
    catch (SQLException e) 
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  return li;
  }
  
  
  
  
  public static List<User> getUser(String email, String password)
  {
    ResultSet resultSet = null;
    List<User> li = new ArrayList<User>();

    
    try 
    {
      Connection con = getConnection();
      PreparedStatement stmt = con.prepareStatement("select * from users where email=? and password=? ");
                                                    stmt.setString(1, email);
                                                    stmt.setString(2, password);
      resultSet = stmt.executeQuery();
    } 
    catch (Exception e) 
    {
      System.out.println(e);
    }
    try 
    {
      while (resultSet.next()) 
      {
        User user = new User();
        user.setId(Integer.parseInt(resultSet.getString(1)));
        user.setName(resultSet.getString(2));
        user.setEmail(resultSet.getString(3));
        user.setPassword(resultSet.getString(4));
        user.setRole(resultSet.getString(5));
        li.add(user);
      }
    }
    catch (SQLException e) 
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return li;
  }
  
  //dodawanie nowego uzytkownika - typu user (nie dodano jeszcze pola role do formularza rejestracji)
  public static int addUser(User u) {
	    int status = 0;
	    try {
	      Connection con = getConnection();
	      PreparedStatement stmt = con.prepareStatement("insert into users (name,email,password,role) values (?,?,?,?)");
	      stmt.setString(1, u.getName());
	      stmt.setString(2, u.getEmail());
	      stmt.setString(3, u.getPassword());
	      stmt.setString(4, "user");
	      status = stmt.executeUpdate();
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	    return status;
	  }
  
  
}
