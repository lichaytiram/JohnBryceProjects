
public class try99 {
	public static void main(String[] args) {

		System.out.println(reverseWords("ehT kciuq nworb xof spmuj revo eht yzal .god"));

	}

	public static String reverseWords(final String original) {
		String fullString = "";
		int index = 0;
		boolean firstTime = true;
		for (int i = 0; i < original.length(); i++) {
			String temp = "";
			if (original.charAt(i) == ' ' || i == original.length() - 1) {
				temp = original.substring(index, i);
				if (i == original.length() - 1)
					fullString += original.charAt(i);
				index = i;
				for (int j = temp.length() - 1; j > -1; j--)
					fullString += temp.charAt(j);
				if (firstTime) {
					fullString += " ";
					firstTime = false;
				}
			}
		}
		return fullString;

	}
}
