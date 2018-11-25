import java.util.Arrays;

public class try116 {
	public static void main(String[] args) {
		String arr1[] = new String[] { "arp", "live", "strong" };
		String arr2[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
		System.out.println(Arrays.deepToString(inArray(arr1, arr2)));
	}

	public static String[] inArray(String[] array2, String[] array1) {
		String s = "";
		for (int i = 0; i < array2.length; i++) {
			boolean check = false;
			for (int j = 0; j < array1.length; j++) {
				for (int chars = 0; chars < array1[j].length(); chars++)
					if (array2[i].charAt(0) == array1[j].charAt(chars))
						if (chars + array2[i].length() - 1 < array1[j].length())
							if (array2[i].equals(array1[j].substring(chars, chars + array2[i].length()))) {
								s += array2[i] + " ";
								check = true;
							}
				if (check)
					break;
			}
		}
		if (!s.equals(array1)) // need work on it
			return new String[] {};
		return s.split(" ");
	}
// dont work yet
}
