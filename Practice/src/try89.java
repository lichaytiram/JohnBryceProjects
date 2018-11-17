
public class try89 {
	public static void main(String[] args) {
		System.out.println(longest("aretheyhere", "yestheyarehere"));
	}

	public static String longest(String s1, String s2) {
		String s = "";
		int theDigit = 97;

		while (theDigit < 123) {
			boolean check = false;
			for (int i = 0; i < s1.length(); i++)
				if (s1.charAt(i) == (char) theDigit) {
					s += (char) theDigit;
					check = true;
					break;

				}
			if (!check)
				for (int i = 0; i < s2.length(); i++)
					if (s2.charAt(i) == (char) theDigit) {
						s += (char) theDigit;
						break;
					}

			theDigit++;
		}
		return s;

	}
}
