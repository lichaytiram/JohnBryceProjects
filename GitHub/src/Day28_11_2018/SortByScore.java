package Day28_11_2018;

import java.util.Comparator;

public class SortByScore implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getScore() - s2.getScore();
	}
}
