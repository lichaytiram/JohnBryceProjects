
public class try31 {
	public static void main(String[] args) {
		System.out.println(isIsogram("mose"));
	}

	public static boolean isIsogram(String str) {
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j) || str.charAt(i) == (int) (str.charAt(j) - 32))
					count++;
				if (count == 2)
					return false;
			}
		}
		return true;
	}
}
