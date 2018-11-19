
public class try102 {
	public static void main(String[] args) {
		System.out.println(accum("abcd"));
	}

	public static String accum(String s) {
		s = s.toLowerCase();
		String temp = "";
		int howMuch = 0;
		for (int i = 0; i < s.length(); i++) {
			temp += s.toUpperCase().charAt(i);
			for (int j = 0; j < howMuch; j++) {
				temp += s.charAt(i);
			}
			if (i != s.length() - 1)
				temp += '-';
			howMuch++;
		}
		return temp;
	}
}
