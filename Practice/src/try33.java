
public class try33 {
	public static void main(String[] args) {
		String s = "ss c defh";
		System.out.println(longestWord(s));

	}

	public static String longestWord(String wordString) {
		String s = "", temp = "";
		for (int i = 0; i < wordString.length(); i++) {

			if (wordString.charAt(i) != ' ')
				temp += wordString.charAt(i);
			if (temp.length() >= s.length()) {
				s = "";
				for (int j = 0; j < temp.length(); j++) {
					s += temp.charAt(j);
				}
			}
			if (wordString.charAt(i) == ' ')
				temp = "";
		}
		return s;
	}
}
