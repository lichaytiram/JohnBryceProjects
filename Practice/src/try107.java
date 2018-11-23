
public class try107 {
	public static void main(String[] args) {
		System.out.println(change("i am love dogs and love cats", "love", "hate", 2));
	}

	public static String change(String s1, String s2, String s3, int numOfShow) {
		for (int i = 0; i < s1.length(); i++)
			if (s1.charAt(i) == s2.charAt(0))
				if ((s1.substring(i, i + s2.length())).equals(s2))
					if (numOfShow <= 1) {
						s1 = s1.substring(0, i) + s3 + s1.substring(i + s2.length(), s1.length());
						break;
					} else
						numOfShow--;
		return s1;
	}
}
