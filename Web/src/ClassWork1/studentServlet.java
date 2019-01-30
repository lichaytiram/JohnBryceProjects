package ClassWork1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class studentServlet
 */
@WebServlet("/studentServlet")
public class studentServlet extends HttpServlet {
	private static ArrayList<Student> myList = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public studentServlet() {
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
		if (myList == null)
			myList = new ArrayList<Student>();
		String name = request.getParameter("name");
		double age = Double.parseDouble(request.getParameter("age"));
		double grade = Double.parseDouble(request.getParameter("grade"));
		String sort = request.getParameter("sortBy");
		myList.add(new Student(name, age, grade));
		JSONArray jsonArr = new JSONArray();
		for (Student student : myList) {
			JSONObject jsonO = new JSONObject();
			jsonO.put("name", student.getName());
			jsonO.put("age", student.getAge());
			jsonO.put("grade", student.getGrade());
			jsonArr.add(jsonO);
		}
		switch (sort) {
		case "ageDesc":
			jsonArr = sortByageDesc(jsonArr);
			break;
		case "ageAcd":
			break;
		case "gradeDesc":
			break;
		case "gradeAcd":
			break;
		case "nameDesc":
			break;
		case "nameAcd":
			break;
		}
		response.getWriter().append(jsonArr.toString());

	}

	public static JSONArray sortByageDesc(JSONArray json) {
		JSONArray jsontoreturn = null;

		for (int i = 0; i < json.size(); i++) {
//			json
		}
		return jsontoreturn;
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
