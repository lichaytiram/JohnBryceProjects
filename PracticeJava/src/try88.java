
public class try88 {
	public static void main(String[] args) {
		System.out.println(stringMerge1("wonderful", "people", 'e'));
		System.out.println(stringMerge2("wonderful", "people", 'e'));

	}

	public static String stringMerge1(String s1, String s2, char letter) {
		String s = "";
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == letter)
				break;
			s += s1.charAt(i);
		}
		boolean check = false;
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == letter)
				check = true;
			if (check)
				s += s2.charAt(i);
		}

		return s;
	}

	public static String stringMerge2(String s1, String s2, char letter) {
		return s1.substring(0, s1.indexOf(letter)) + s2.substring(s2.indexOf(letter));
	}
}
