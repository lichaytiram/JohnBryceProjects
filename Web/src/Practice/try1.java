package Practice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class try1
 */
@WebServlet("/try1")
public class try1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public try1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Animal a1 = new Animal("Dog", "ahi", 9);
		Animal a2 = new Animal("Cat", "mitchi", 2);
		Animal a3 = new Animal("Cat", "momo", 4);
		Animal a4 = new Animal("bird", "kiki", 23);

		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();
		JSONObject json3 = new JSONObject();
		JSONObject json4 = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(json1);
		jsonArray.add(json2);
		jsonArray.add(json3);
		jsonArray.add(json4);
		json1.put("type", a1.getType());
		json1.put("name", a1.getName());
		json1.put("age", a1.getAge());
		json2.put("type", a2.getType());
		json2.put("name", a2.getName());
		json2.put("age", a2.getAge());
		json3.put("type", a3.getType());
		json3.put("name", a3.getName());
		json3.put("age", a3.getAge());
		json4.put("age", a4.getAge());
		json4.put("type", a4.getType());
		json4.put("name", a4.getName());

		response.getWriter().append("<h1>" + jsonArray.toString() + "</h1>");

//		String str = request.getParameter("part");
//
//		switch (str) {
//
//		// http://localhost:8080/15_url_parameters/GreetingServlet?part=night
//		case "night":
//			response.getWriter().append("now is: ").append(str).append(" So have sweet dreams");
//			break;
//
//		// http://localhost:8080/15_url_parameters/GreetingServlet?part=morning
//		case "morning":
//			response.getWriter().append("now is: ").append(str).append(" So have a good day");
//			break;
//
//		default:
//			response.getWriter().append("I do not recognize your choice: " + str);
//			break;
//
//		}

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
