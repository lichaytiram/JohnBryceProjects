
public class try40 {
	public static void main(String[] args) {
		String[] s1 = new String[] { "hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt",
				"znnnnfqknaz", "qqquuhii", "dvvvwz" };
		String[] s2 = new String[] { "cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww" };
		System.out.println(mxdiflg(s1, s2));
	}

	public static int mxdiflg(String[] a1, String[] a2) {
		if (a1.length == 0 && a2.length == 0)
			return -1;
		int countA1 = 0, countA2 = 0;
		for (int i = 0; i < a1.length; i++) {
			boolean check = true;
			for (int j = 0; j < a1[i].length(); j++) {
				if (a1[i].charAt(j) != 'x')
					countA1++;
				else {
					countA1++;
					check = false;
					break;
				}
			}
			if (check == false)
				break;
			if (check == true && i == a1.length - 1)
				countA1 = -1;
		}
		for (int i = 0; i < a2.length; i++) {
			boolean check = true;
			for (int j = 0; j < a2[i].length(); j++) {
				if (a2[i].charAt(j) != 'y')
					countA2++;
				else {
					countA2++;
					check = false;
					break;
				}
			}
			if (check == false)
				break;
			if (check == true && i == a2.length - 1)
				countA2 = -1;
		}
		if (countA1 == -1 || countA2 == -1)
			return Math.abs(countA1 * countA2);
		return Math.abs(countA1 - countA2);
	}
}
