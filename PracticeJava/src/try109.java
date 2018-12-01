
public class try109 {
	public static void main(String[] args) {
		System.out.println(closest(new int[] { 3, 4, 8, 10, 18, 22, 23, 29, 32, 33 }, 43));
	}

	public static String closest(int[] arr, int k) {
		int num1 = arr[0], num2 = arr[0];
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr.length; j++) {
				while (arr[i] + arr[arr.length / 2 - 1] <= k && j + (arr.length / 2) - 1 < arr.length)
					j += arr.length / 2 - 1;

				if (Math.abs((k - (arr[i] + arr[j]))) < Math.abs((k - (num1 + num2)))) {
					num1 = arr[i];
					num2 = arr[j];
				} else if (Math.abs((k - (arr[i] + arr[j]))) > k)
					break;
			}

		return "numbers is (" + num1 + "," + num2 + ") closest to k->" + k;
	}
}
