package Practice1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

/**
 * Servlet implementation class cook
 */
@WebServlet("/cook")
public class cook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookieArray = request.getCookies();
		String nameToAdd = request.getParameter("add");
		String fullCook = "";
		if (cookieArray != null)
			for (Cookie cookie : cookieArray) {
				if (cookie.getName().equals("key4"))
					fullCook = cookie.getValue();
			}
		fullCook += nameToAdd;

		if (nameToAdd != null)
			if (!nameToAdd.equals("")) {
				Cookie c = new Cookie("key4", fullCook + "&");
				c.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(c);
			}
		response.getWriter();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
