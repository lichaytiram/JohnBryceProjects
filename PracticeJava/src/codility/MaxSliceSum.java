package codility;

public class MaxSliceSum {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 3, 2, -6, 4, 0 }));

	}

	public static int solution(int[] arr) {

		if (arr == null || arr.length == 0)
			return 0;

		int maxSum = arr[0];

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] > maxSum)
				maxSum = arr[i];

			if (arr[i] + arr[i + 1] > maxSum)
				maxSum = arr[i] + arr[i + 1];

		}

		if (arr[arr.length - 1] > maxSum)
			maxSum = arr[arr.length - 1];

		return maxSum;

	}

}
