
public class try151 {

	public static void main(String[] args) {

		System.out.println(findMax(new int[] { -4, 8, 9, -1, -17, -20, 30, -4, 16, -2, 5, -18 }));

	}

	public static int findMax(int[] arr) {
		int maxSum = 0, currentSum = 0;

		for (int i = 0; i < arr.length; i++) {

			if (currentSum < 0) {

				currentSum = 0;

			} else
				currentSum += arr[i];

			if (maxSum < currentSum)
				maxSum = currentSum;
		}

		return maxSum;
	}
}
