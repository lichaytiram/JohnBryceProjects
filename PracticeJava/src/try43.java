
public class try43 {
	public static void main(String[] args) {

		System.out.println(reverse("hello world"));

	}

	public static String reverse(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			s += str.charAt(str.length() - 1 - i);
		}
		return s;
	}

}
