
public class try172 {

	public static void main(String[] args) {

		System.out.println(changeToUpperCase("aBcEG"));

	}

	public static String changeToUpperCase(String s) {

		if (s == null || s.isEmpty())
			return "";

		if (s.charAt(0) >= 'a')
			s = s.replace(s.charAt(0), (char) (s.charAt(0) - 32));

		return s.charAt(0) + changeToUpperCase(s.substring(1));
	}
}
