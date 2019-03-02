
public class try149 {
	public static void main(String[] args) {

		System.out.println(encryptThis("A wise [ ] old"));

	}

	public static String encryptThis(String text) {
		String all = "";
		String[] split = text.split(" ");
		for (int i = 0; i < split.length; i++) {
			if (isNormal(split[i])) {
				switch (split[i].length()) {
				case 0:
					all += " ";
					break;
				case 1:
					all += split[i].charAt(0) + 0 + " ";
					break;
				case 2:
					all += split[i].charAt(0) + 0 + "" + split[i].charAt(1) + " ";
					break;
				default:
					all += split[i].charAt(0) + 0 + "" + split[i].charAt(split[i].length() - 1)
							+ split[i].substring(2, split[i].length() - 1) + split[i].charAt(1) + " ";
					break;
				}
			} else
				all += " ";
		}
		return all.trim();
	}

	public static boolean isNormal(String words) {
		for (int i = 0; i < words.length(); i++)
			if (!((words.charAt(i) >= 'a' && words.charAt(i) <= 'z')
					|| words.charAt(i) >= 'A' && words.charAt(i) <= 'Z'))
				return false;
		return true;
	}

}
