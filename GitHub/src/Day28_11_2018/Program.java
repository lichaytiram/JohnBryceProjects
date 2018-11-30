package Day28_11_2018;

import java.util.ArrayList;
import java.util.Collections;

public class Program {
	public static void main(String[] args) {

		ArrayList<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Moshe"));
		studentList.add(new Student("Dora"));
		studentList.add(new Student("Dana"));
		studentList.add(new Student("Edi"));
		studentList.add(new Student("Ronen"));
		System.out.println("regular sort");
		for (Student s : studentList)
			System.out.println(s);
		System.out.println("\nSortByName -");
		Collections.sort(studentList, new SortByName());
		for (Student s : studentList)
			System.out.println(s);
		System.out.println("\nSortByAge -");
		Collections.sort(studentList, new SortByAge());
		for (Student s : studentList)
			System.out.println(s);
		System.out.println("\nSortByScore -");
		Collections.sort(studentList, new SortByScore());
		for (Student s : studentList)
			System.out.println(s);

	}
}
