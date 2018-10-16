package Day14_10_2018;

public class HM1 {
	public static void main(String[] args) {
		System.out.println(divide("abcdefghijklmnopqrstu"));
	}

	public static String divide(String s) {
		String newS = "";
		int parts = 0;
		for (int i = 2; i <= s.length(); i++) {
			if (s.length() % i == 0) {
				parts = i;
				break;
			}
		}
		int tempParts = parts;
		for (int i = 0; i < s.length(); i++) {
			newS += s.charAt(i);
			if (i == tempParts - 1) {
				tempParts += parts;
				newS += "\n";
			}
		}

		return newS;
	}
}
