
public class try67 {
	public static void main(String[] args) {

		String s = "what time are we climbing up to the volcano";
		System.out.println(high(s));

	}

	public static String high(String s) {
		s = s.toLowerCase();
		String sNew = "";
		int summax = 0;
		for (int i = 0; i < s.length(); i++) {
			int sum = 0;
			String sTemp = "";
			while (s.charAt(i) != ' ') {
				sTemp += s.charAt(i);
				sum += s.charAt(i) - 96;

				if (i == s.length() - 1)
					break;
				i++;
			}
			if (sum > summax) {
				sNew = sTemp;
				summax = sum;
			}
		}
		return sNew;
	}

}
