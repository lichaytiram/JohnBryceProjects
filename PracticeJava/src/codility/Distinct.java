package codility;

import java.util.Arrays;

public class Distinct {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, -1, 1, 4, 1, -1, 4, 8, 8 }));

	}

	public static int solution(int[] arr) {

		if (arr == null || arr.length == 0)
			return 0;

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));
		if (arr[0] != arr[1])
			return arr[0];

		if (arr[arr.length - 1] != arr[arr.length - 2])
			return arr[arr.length - 1];

		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
				return arr[i];
		}
		return 0;
	}
}
