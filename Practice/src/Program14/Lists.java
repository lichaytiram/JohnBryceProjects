package Program14;

import java.util.ArrayList;

public class Lists {
	public static void main(String[] args) {

		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		l1.add(2);
		l1.add(3);
		l1.add(3, 4);
		System.out.println(l1.toString());
		l1.clear();
		System.out.println(l1.toString());
		System.out.println(l1.isEmpty());
		l1.add(0, 5);
		l1.add(1, 2);
		System.out.println(l1.isEmpty());
		System.out.println(l1.toString());
		System.out.println(l1.contains(2));
		System.out.println(l1.indexOf(2));
		System.out.println("now String array");
		ArrayList<String> s1 = new ArrayList<String>();
		s1.add("hi");
		s1.add("omg");
		s1.add("easy");
		System.out.println(s1.toString());
		s1.remove(0);
		System.out.println(s1.toString());
		System.out.println(s1.size());
	}
}
