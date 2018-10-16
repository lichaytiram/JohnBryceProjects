
public class try24 {
	public static void main(String[] args) {
		System.out.println(disemvowel("This website is for losers LOL!"));
	}

	public static String disemvowel(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != 'e' && str.charAt(i) != 'i' && str.charAt(i) != 'o' && str.charAt(i) != 'u'
					&& str.charAt(i) != 'a' && str.charAt(i) != 'O' && str.charAt(i) != 'I' && str.charAt(i) != 'U'
					&& str.charAt(i) != 'A' && str.charAt(i) != 'E')
				s += str.charAt(i);
		}

		return s;
	}

}
