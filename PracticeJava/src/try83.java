
public class try83 {
	public static void main(String[] args) {
		char[] charArrays = new char[] { 'a', 'b', 'O', 'D', 'e', 'E', 'o', ' ', 'f' };

		String arr = String.copyValueOf(charArrays);
		System.out.println(getCount(arr));

	}

	public static int getCount(String str) {
		int vowelsCount = 0;
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'u' || str.charAt(i) == 'i' || str.charAt(i) == 'e'
					|| str.charAt(i) == 'o')
				vowelsCount++;
		}
		return vowelsCount;
	}
}
