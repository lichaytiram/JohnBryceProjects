
public class try41 {
	public static void main(String[] args) {
		int[] array = new int[] { 5, 4, 3, 2, 3 };
		System.out.println(isSortedAndHow(array));

	}

	public static String isSortedAndHow(int[] array) {
		int temp = array[0];
		for (int i = 0; i < array.length; i++) {
			if (temp <= array[i]) {
				temp = array[i];
			} else
				break;
			if (i == array.length - 1)
				return "yes, ascending";
		}

		for (int i = 0; i < array.length; i++) {
			if (temp >= array[i]) {
				temp = array[i];
			} else
				break;
			if (i == array.length - 1)
				return "yes, descending";
		}
		return "no";
	}
}
