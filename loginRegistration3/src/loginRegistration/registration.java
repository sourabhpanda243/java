package loginRegistration;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String school=request.getParameter("school");
		String reg_no=request.getParameter("reg_no");
		user u=new user();
		u.setName(uname);
		u.setReg_no(reg_no);
		u.setPass(pass);
		u.setSchool(school);
		regi_dao rg=new regi_dao();
		int row=0;
		try {
			row = rg.register(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().println(row+" row updated");
		response.sendRedirect("view.jsp");
	}
}
