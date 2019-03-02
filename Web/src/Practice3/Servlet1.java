package Practice3;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet3")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int x = Integer.parseInt(request.getParameter("n1"));
		int y = Integer.parseInt(request.getParameter("n2"));
		int z = x + y;

		HttpSession session = request.getSession();
		session.setAttribute("x", x);
		session.setAttribute("y", y);
		session.setAttribute("z", z);

		Cookie c1 = new Cookie("X1", x + "");
		Cookie c2 = new Cookie("Y1", y + "");
		Cookie c3 = new Cookie("Z1", z + "");
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		response.sendRedirect("Servlet4");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("in post");
	}

}
