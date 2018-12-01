
public class try95 {
	public static void main(String[] args) {

		System.out.println(repeat("abX", 4));
	}

	public static String repeat(String string, long n) {
		String temp = string;
		for (long i = 0; i < n - 1; i++)
			string = string.concat(temp);
		return string;
	}
}
