
public class try18 {
	public static void main(String[] args) {
		System.out.println(solution("world"));

	}

	public static String solution(String str) {
		String x = "";
		for (int i = 0; i < str.length(); i++) {
			x += str.charAt(str.length() - 1 - i);
		}
		return x;
	}
}
