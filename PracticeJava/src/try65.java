
public class try65 {
	public static void main(String[] args) {
		System.out.println(order("is2 Thi1s T4est 3a"));

	}

	public static String order(String words) {
		String s = "";
		if (words.length() == 0)
			return s;
		int count = Count(words);
		for (int i = 1; i <= count; i++) {
			String temp = "";
			for (int j = 0; j < words.length(); j++) {

				if ((words.charAt(j)) == (char) (i + 48)) {
					int min = j, max = j;
					while (words.charAt(min) != ' ' && min != 0)
						min--;
					while (words.charAt(max) != ' ' && max != words.length() - 1)
						max++;
					for (int add = min; add <= max; add++) {
						temp += words.charAt(add);
					}
					temp += ' ';
				}

			}
			s += temp;
		}
		s = s.replaceAll("   ", " ");
		s = s.replaceAll("  ", " ");
		if (s.charAt(0) == ' ')
			s = s.substring(1);
		if (s.charAt(s.length() - 1) == ' ')
			s = s.substring(0, s.length() - 1);
		return s;

	}

	public static int Count(String s) {
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				count++;
		}

		return count;
	}
}
