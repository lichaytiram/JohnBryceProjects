package Program23;

import java.util.Hashtable;

public class Program {
	public static void main(String[] args) {
		Student[] sArr = new Student[5];
		for (int i = 0; i < sArr.length; i++) {

			sArr[i] = new Student(randomS(), randomI());

		}
		for (Student i : sArr) {
			System.out.println(i);
		}
		System.out.println();
		Hashtable<String, Student> listH = new Hashtable<>();
		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i].getGrade() > 80)
				listH.put(sArr[i].getName(), sArr[i]);
		}

		for (int i = 0; i < sArr.length; i++) {
			if (listH.get(sArr[i].getName()) != null)
				System.out.println(listH.get(sArr[i].getName()));
		}
	}

	public static int randomI() {
		return (int) (Math.random() * 51) + 50;
	}

	public static String randomS() {
		String name = "";
		int length = ((int) (Math.random() * 4 + 2));
		for (int i = 0; i < length; i++) {
			name += (char) (Math.random() * 26 + 97);
		}
		return name;
	}
}
