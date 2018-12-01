import java.util.Arrays;

public class try115 {
	public static void main(String[] args) {
		String arr1[] = new String[] { "live", "alive", "harp", "sharp", "strong" };
		String arr2[] = new String[] { "arp", "live", "strong" };
		System.out.println(Arrays.deepToString(inArray(arr1, arr2)));
	}

	public static String[] inArray(String[] array1, String[] array2) {
		String s = "";
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array1.length; j++) {
				if (array2[i].contains(array1[j]))
					s += array2[i] + " ";
			}
		}
		return s.split(" ");
	}

}
