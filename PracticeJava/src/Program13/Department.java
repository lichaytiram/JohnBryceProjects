package Program13;

import java.util.Arrays;

public class Department {
	private String departmentName;
	private Lecturer[] l;
	private Student[] s = new Student[4];

	public Department(String departmentName, Lecturer[] l, Student[] s) {
		super();
		this.departmentName = departmentName;
		this.l = Arrays.copyOf(l, l.length);
		this.s = Arrays.copyOf(s, s.length);
	}

	@Override
	public String toString() {
		return "\nDepartment [departmentName=" + departmentName + ",\nLecturer=" + Arrays.toString(l) + ",\nStudent="
				+ Arrays.toString(s);
	}

}
