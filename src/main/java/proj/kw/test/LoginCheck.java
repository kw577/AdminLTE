package proj.kw.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proj.kw.dao.UserDAO;
import proj.kw.dto.User;



/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/loginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		System.out.println("\n\nemail: "+ email);
		System.out.println("passwword: "+ password);
		
		
		//Sprawdzenie w bazie danych
		List<User> li = new ArrayList<User>();
		li = UserDAO.getUser(email, password);
		
		
		//istnieje uzytkownik o podanych danych logowania
		if(li.size() > 0) {
			User user1 = li.get(0);
			
			
			System.out.println("\n\n\nChecked User name:" + user1.getName() + "#");
			System.out.println("Checked User email:" + user1.getEmail()+ "#");
			System.out.println("Checked User password:" + user1.getPassword()+ "#");
			System.out.println("Checked User role:" + user1.getRole()+ "#");
			
			//sprawdzamy czy ten uzytkownik jest adminem
			if(user1.getRole().equals("admin")) {
				
				System.out.println("\n\nAdmin logged in !!!");
				HttpSession session = request.getSession();
				session.setAttribute("userName", email);
				response.sendRedirect("http://localhost:8080/AdminLTE/welcome");
				
				//response.sendRedirect("http://localhost:8080/AdminLTE/");
			}else {
				response.sendRedirect("http://localhost:8080/AdminLTE/login");
				System.out.println("\n\nLogin failed!!!");
			}
			
			
			
			
		}
		else {
			response.sendRedirect("http://localhost:8080/AdminLTE/login");
			System.out.println("\n\nLogin failed!!!");
		}
		
	}

}
