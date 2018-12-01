package Program1;

public class Program {

	public static void main(String[] args) {
		Lecturer l1 = new Lecturer("moshe", 5, "moka");
		Lecturer l2 = new Lecturer("doron", 1, "fistuk");
		Lecturer l3 = new Lecturer("doron", 3, "fistuk");
		College c = new College("achva");
		System.out.println(c.addLecturer(l1));
		System.out.println(c.addLecturer(l2));
		System.out.println(c.addLecturer(l3));
		System.out.println(c.getName());
		System.out.println(c.getLecturer(0).getNumOfTimesPenFalls());
		System.out.println(c.getLecturer(1).getNumOfTimesPenFalls());
		System.out.println(c.getLecturer(2).getNumOfTimesPenFalls());
		c.fixL();
		System.out.println(c.getLecturer(0).getNumOfTimesPenFalls());
		System.out.println(c.getLecturer(1).getNumOfTimesPenFalls());
		System.out.println(c.getLecturer(2).getNumOfTimesPenFalls());

	}
}
