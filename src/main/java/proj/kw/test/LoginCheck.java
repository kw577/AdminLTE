package proj.kw.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if(email.equals("admin@email.com") && password.equals("pass1")) {
			
			System.out.println("\n\nUser logged in !!!");
			HttpSession session = request.getSession();
			session.setAttribute("userName", email);
			response.sendRedirect("http://localhost:8080/AdminLTE/welcome");
			
			//response.sendRedirect("http://localhost:8080/AdminLTE/");
		}else {
			response.sendRedirect("http://localhost:8080/AdminLTE/login");
			System.out.println("\n\nLogin failed!!!");
		}
		
	}

}
