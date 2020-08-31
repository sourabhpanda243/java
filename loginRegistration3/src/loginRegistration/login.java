package loginRegistration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		userdtl u1=new userdtl();
		if(u1.check(uname,pass)!=null)
		{
			user u=u1.check(uname,pass);
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			response.sendRedirect("welcome.jsp");
		}
		else response.sendRedirect("view.jsp");
	}

}
