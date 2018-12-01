
public class try42 {
	public static void main(String[] args) {
		System.out.println(getMiddle("omg"));

	}

	public static String getMiddle(String word) {
		if (word.length() % 2 != 0)
			return word.charAt(word.length() / 2) + "";
		return word.charAt((word.length() / 2) - 1) + "" + word.charAt(word.length() / 2);
	}
}
