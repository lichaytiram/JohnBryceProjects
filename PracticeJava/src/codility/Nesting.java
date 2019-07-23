package codility;

public class Nesting {

	public static void main(String[] args) {

		System.out.println(solution("(((())))"));

	}

	public static int solution(String s) {

		if (s == null)
			return 0;

		int enumSimbol = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				enumSimbol++;
			else
				enumSimbol--;

			if (enumSimbol < 0)
				return 0;

		}
		if (enumSimbol == 0)
			return 1;

		return 0;

	}

}
