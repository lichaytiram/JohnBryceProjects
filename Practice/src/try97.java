
public class try97 {
	public static void main(String[] args) {
		System.out.println(vowel2Index("this is my string"));
		System.out.println(vowel2Index("Tomorrow is going to be raining"));

	}

	public static String vowel2Index(String s) {
		int print = 1;
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'i' || s.charAt(i) == 'u' || s.charAt(i) == 'e'
					|| s.charAt(i) == 'o')
				temp += print;
			else
				temp += s.charAt(i);
			print++;
		}
		return temp;
	}

}
