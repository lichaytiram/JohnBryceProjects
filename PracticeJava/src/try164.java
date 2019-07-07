
public class try164 {

	public static void main(String[] args) {

		System.out.println(showRecursive("aabab", 'b'));

	}

	public static int showRecursive(String s, char label) {

		if (s == null || s.length() == 0)
			return 0;

		if (s.charAt(s.length() - 1) == label)
			return 1 + showRecursive(s.substring(0, s.length() - 1), label);

		return showRecursive(s.substring(0, s.length() - 1), label);

	}

}
