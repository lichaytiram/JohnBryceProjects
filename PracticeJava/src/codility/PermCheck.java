package codility;

import java.util.Arrays;

public class PermCheck {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 4, 5, 2 }));
	}

	public static int solution(int[] arr) {
		
		if (arr == null || arr.length == 0)
			return 0;

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++)
			if (arr[i] != i + 1)
				return 0;

		return 1;
	}

}
