package Practice2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
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
		request.setAttribute("sum", z);
		response.getWriter().append("Served at: 1 and number is:" + z + "\n");
		RequestDispatcher di = request.getRequestDispatcher("Servlet2");
		di.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("in post");
	}

}
