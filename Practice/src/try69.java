
public class try69 {
	public static void main(String[] args) {
		String s = "CbcBcbaA";
		System.out.println(s);
		System.out.println(findChildren(s));
	}

	static String findChildren(String text) {
		String s = "";
		char c = 'A';
		while (c != '[') {
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == c)
					s += text.charAt(i);
			}
			char tempC = (char) (c + 32);
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == tempC)
					s += text.charAt(i);
			}
			c += (char) 1;
		}

		return s;
	}
}
