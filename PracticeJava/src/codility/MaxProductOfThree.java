package codility;

import java.util.Arrays;

public class MaxProductOfThree {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 1, 1, 4, 7, 2, 5 }));

	}

	public static int solution(int[] arr) {

		if (arr == null || arr.length < 3)
			return 0;

		Arrays.sort(arr);

		int n1 = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
		int n2 = arr[0] * arr[1] * arr[arr.length - 1];

		return Math.max(n1, n2);

	}

}
