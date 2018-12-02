
public class try131 {
	public static void main(String[] args) {
		System.out.println(solve("abracadabra", 50));

	}

	public static String solve(String s, int k) {
		char c = 'a';
		while (k > 0) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == c) {
					s = s.replaceFirst(c + "", "");
					k--;
					break;
				}
				if (i == s.length() - 1)
					c++;
			}
			if (s.length() == 0)
				return s;
		}
		return s;
	}
}
