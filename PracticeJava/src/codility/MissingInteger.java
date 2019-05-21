package codility;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 6, 4, 1, 2 }));

	}

	public static int solution(int[] arr) {

		int lowerDigit = 1;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == lowerDigit)
				lowerDigit++;
			else if (arr[i] > lowerDigit)
				break;
		}

		return lowerDigit;
	}

}
