package Day14_10_2018;

public class HM2 {

	public static void main(String[] args) {
		System.out.println(duplicate("the quick brown fox", "queen"));
	}

	public static String duplicate(String full, String clear) {
		for (int i = 0; i < clear.length(); i++) {
			full = full.replaceAll(clear.charAt(i) + "", "");
		}
		return full;
	}
}
