
public class try46 {
	public static void main(String[] args) {
		System.out.println(greet_jedi("Beyonce", "Knowles"));
	}

	public static String greet_jedi(String first, String last) {
		String s = "Greetings, master ";
		s += last.charAt(0);
		s += last.charAt(1);
		s += last.charAt(2);
		s += first.charAt(0);
		s += first.charAt(1);

		return s;

	}
}
