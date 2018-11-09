package Program22;

import java.util.ArrayList;

public class Program {
	public static void main(String[] args) {
		People p1 = new People("moshe", 25);
		People p2 = new People("doron", 36);
		People p3 = new People("shlomit", 6);

		ArrayList<People> peopleList = new ArrayList<People>();
		peopleList.add(p1);
		peopleList.add(p2);
		peopleList.add(p3);
		System.out.println(peopleList);
		System.out.println(peopleList.remove(new People("doron", 36)));
		System.out.println(peopleList.remove(p1));
		System.out.println(peopleList);

		System.out.println("---------------------------------------------");
		ArrayList<Integer> listInit = new ArrayList<>();
		listInit.add(12);
		listInit.add(45);
		listInit.add(80);
		System.out.println(listInit);
		System.out.println(listInit.remove(0));
		System.out.println(listInit);
		Integer x = 80;
		System.out.println(listInit.remove(x));
		System.out.println(listInit);

	}
}
