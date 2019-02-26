
public class try149 {
	public static void main(String[] args) {

		System.out.println(encryptThis("8A wise old"));

	}

	public static String encryptThis(String text) {
		String all = "";
		String[] split = text.split(" ");
		for (int i = 0; i < split.length; i++) {

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
		}
		return all.trim();
	}
}
