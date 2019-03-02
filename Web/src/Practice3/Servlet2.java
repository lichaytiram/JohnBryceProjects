package Practice3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet4")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();
		int x = (int) s.getAttribute("x");
		int y = (int) s.getAttribute("y");
		int z = (int) s.getAttribute("z");
		response.getWriter().append("Your sum is(s1): [ " + x + " + " + y + " = " + z + " ]");
		Cookie[] c = request.getCookies();
		int x1 = 0, y1 = 0, z1 = 0;
		for (Cookie cookie : c)
			if (cookie.getName().equals("X1"))
				x1 = Integer.parseInt(cookie.getValue());
			else if (cookie.getName().equals("Y1"))
				y1 = Integer.parseInt(cookie.getValue());
			else if (cookie.getName().equals("Z1"))
				z1 = Integer.parseInt(cookie.getValue());

		response.getWriter().append("\nYour sum is(s2): [ " + x1 + " + " + y1 + " = " + z1 + " ]");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
