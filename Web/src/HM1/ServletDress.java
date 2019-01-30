package HM1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ServletDress
 */
@WebServlet("/ServletDress")
public class ServletDress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDress() {
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
		Dress[] dressArray = new Dress[5];
		dressArray[0] = new Dress("Test", "MenX400", "shirt", 250, "small", new String[] { "white", "blue", "gray" });
		dressArray[1] = new Dress("Test", "MenY400", "Shorts", 250, "small", new String[] { "white", "blue" });
		dressArray[2] = new Dress("Test", "MenX78", "shoes", 250, "big", new String[] { "black", "blue", "gray" });
		dressArray[3] = new Dress("Test", "MenX400", "shirt", 250, "very big", new String[] { "white" });
		dressArray[4] = new Dress("Test", "WomenX0", "shoes", 250, "medium", new String[] { "red", "black", "pink" });
		JSONArray jsonArray = new JSONArray();
		// one way
		for (Dress dress : dressArray) {
			JSONObject o = new JSONObject();
			o.put("manufacturer", dress.getManufacturer());
			o.put("model", dress.getModel());
			o.put("type", dress.getType());
			o.put("price", dress.getPrice());
			o.put("size", dress.getSize());
			o.put("color", dress.getColor());
			jsonArray.add(o);
		}

		// second way (isn't best match)
//		for (Dress dress : dressArray) {
//			JSONObject o = new JSONObject();
//			o.put("", dress);
//			jsonArray.add(o);
//		}

		response.getWriter().append("<h1 style=\"color:blue\">" + jsonArray.toString() + "</h1>");
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
