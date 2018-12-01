
public class try50 {
	public static void main(String[] args) {
		System.out.println(duplicateCount("abcde"));
	}

	public static int duplicateCount(String text) {
		int sum = 0;
		text = text.substring(0, text.length()).toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < text.length(); j++) {
				if (text.charAt(i) == text.charAt(j) && i != j && text.charAt(i) != ' ') {
					sum++;
					text = text.replace(text.charAt(i), ' ');
					break;
				}
			}
		}
		return sum;
	}
}
