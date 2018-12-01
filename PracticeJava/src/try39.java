
public class try39 {
	public static void main(String[] args) {

		System.out.println(reverseLetter("ultr53o?n"));

	}

	public static String reverseLetter(String str) {
		String s = "";
		int check = str.length() - 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(check) >= 'a' && str.charAt(check) <= 'z'
					|| str.charAt(check) >= 'A' && str.charAt(check) <= 'Z')
				s += str.charAt(check);
			check--;
		}
		return s;
	}
}
