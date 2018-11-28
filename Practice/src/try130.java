
public class try130 {
	public static void main(String[] args) {
		System.out.println(printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"));
	}

	public static String printerError(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) > 'm')
				sum++;
		return sum + "/" + s.length();
	}
}
