
public class try51 {
	public static void main(String[] args) {
		System.out.println(duplicateCount("aA11"));

	}

	public static int duplicateCount(String text) {
		int num = 0;
		text = text.toLowerCase();
		while (text.length() > 0) {
			String s = text.charAt(0) + "";
			text = text.substring(1, text.length());
			if (text.contains(s))
				num++;
			text = text.replace(s, "");
		}
		return num;
	}
}
