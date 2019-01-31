package ClassWork1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

		Comparator<Student> ageAcd = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.getAge() > s2.getAge())
					return 1;
				else if (s1.getAge() < s2.getAge())
					return -1;
				return 0;
			}
		};
		Comparator<Student> ageDesc = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.getAge() < s2.getAge())
					return 1;
				else if (s1.getAge() > s2.getAge())
					return -1;
				return 0;
			}
		};
		Comparator<Student> gradeAcd = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.getGrade() > s2.getGrade())
					return 1;
				else if (s1.getGrade() < s2.getGrade())
					return -1;
				return 0;
			}
		};
		Comparator<Student> gradeDesc = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.getGrade() < s2.getGrade())
					return 1;
				else if (s1.getGrade() > s2.getGrade())
					return -1;
				return 0;
			}
		};

		Comparator<Student> nameAcd = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.getName().charAt(0) > s2.getName().charAt(0))
					return 1;
				else if (s1.getName().charAt(0) < s2.getName().charAt(0))
					return -1;
				return 0;
			}
		};
		Comparator<Student> nameDesc = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.getName().charAt(0) < s2.getName().charAt(0))
					return 1;
				else if (s1.getName().charAt(0) > s2.getName().charAt(0))
					return -1;
				return 0;
			}
		};

		switch (sort) {
		case "ageDesc":
			Collections.sort(myList, ageDesc);
			break;
		case "ageAcd":
			Collections.sort(myList, ageAcd);
			break;
		case "gradeDesc":
			Collections.sort(myList, gradeDesc);
			break;
		case "gradeAcd":
			Collections.sort(myList, gradeAcd);
			break;
		case "nameDesc":
			Collections.sort(myList, nameDesc);
			break;
		case "nameAcd":
			Collections.sort(myList, nameAcd);
			break;
		}

		JSONArray jsonArr = new JSONArray();
		for (Student student : myList) {
			JSONObject jsonO = new JSONObject();
			jsonO.put("name", student.getName());
			jsonO.put("age", student.getAge());
			jsonO.put("grade", student.getGrade());
			jsonArr.add(jsonO);
		}
		response.getWriter().append(jsonArr.toString());

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
