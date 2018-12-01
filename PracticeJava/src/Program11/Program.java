package Program11;

public class Program {
	public static void main(String[] args) {
		Date d1 = new Date(17, 4, 1942);
		Date d2 = new Date(21, 8, 1945);
		Date d3 = new Date(8, 5, 1980);
		Person p1 = new Person("gogo", "", "", d1);
		Person p2 = new Person("gigi", "", "", d2);
		Person p3 = new Person("momo", "gogo", "gigi", d3);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
	}
}
