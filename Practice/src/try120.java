
public class try120 {
	public static void main(String[] args) {

		System.out.println(solve("code"));
	}

	public static String solve(final String str) {
		int countB = 0, countS = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				countB++;
			else
				countS++;

		}
		if (countB > countS)
			return str.toUpperCase();
		return str.toLowerCase();
	}
}
