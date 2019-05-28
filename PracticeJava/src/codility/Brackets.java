package codility;

public class Brackets {
	public static void main(String[] args) {

		System.out.println(solution(")("));

	}

	public static int solution(String s) {

		if (s == null || s.isEmpty())
			return 1;

		int length = s.length();

		for (int i = 0; i < s.length() / 2; i++) {
			length--;

			if (s.charAt(i) == '(' && s.charAt(length) == ')') {
				continue;

			} else if (s.charAt(i) == ')' && s.charAt(length) == '(') {
				continue;

			} else if (s.charAt(i) == '{' && s.charAt(length) == '}') {
				continue;

			} else if (s.charAt(i) == '}' && s.charAt(length) == '{') {
				continue;

			} else if (s.charAt(i) == '[' && s.charAt(length) == ']') {
				continue;

			} else if (s.charAt(i) == ']' && s.charAt(length) == '[') {
				continue;

			} else if (s.charAt(i) == s.charAt(length)) {
				continue;

			} else
				return 0;
		}

		return 1;
	}
}
