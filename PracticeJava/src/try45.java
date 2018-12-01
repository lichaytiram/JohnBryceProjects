
public class try45 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("absbea"));
	}

	public static int longestPalindrome(String s) {
		int max = 0, maxTemp = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					int lengthLeft = i, lengthRight = j;
					while (lengthLeft < lengthRight) {
						if (s.charAt(lengthLeft) == s.charAt(lengthRight)) {
							lengthLeft++;
							lengthRight--;
							maxTemp += 2;
							if (lengthRight == lengthLeft)
								maxTemp++;
						} else {
							maxTemp = 0;
							break;

						}

					}

					if (maxTemp > max)
						max = maxTemp;
					maxTemp = 0;
				}
			}
		}
		if (s.length() == 0)
			return 0;
		if (max == 0)
			return 1;
		return max;
	}
}
