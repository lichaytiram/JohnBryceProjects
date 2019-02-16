package ClassWork3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/basket")
public class basket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ArrayList<String> myBasket = new ArrayList<String>();

	public basket() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONArray array = new JSONArray();

		for (list object : list.values()) {
			JSONObject o = new JSONObject();
			o.put("key", object.toString());
			array.add(o);
		}
		response.getWriter().append(array.toString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		myBasket.add(name);
		System.out.println(myBasket);
//		System.out.println(request.getParameter("name"));

//		System.out.println(request.getReader().lines().collect(Collectors.joining())); another way with JSON

	}
}
