
public class try28 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		System.out.println(oddOrEven(arr));
	}

	public static String oddOrEven(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		if (sum % 2 == 0)
			return "even";
		return "odd";
	}
}
