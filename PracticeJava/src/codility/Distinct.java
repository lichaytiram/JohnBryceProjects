package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct {

	public static void main(String[] args) {
		System.out.println(solution1(new int[] { 1, 13, 1, 1, 4, 1, 1, 4, 8, 8 }));
		System.out.println(solution(new int[] { 1, 13, 1, 1, 4, 1, 1, 4, 8, 8 }));

	}

	public static int solution1(int[] arr) {

		if (arr == null || arr.length == 0)
			return 0;

		Arrays.sort(arr);

		int count = 1;

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] != arr[i + 1])
				count++;

		}

		return count;
	}

	public static int solution(int[] arr) {

		if (arr == null || arr.length == 0)
			return 0;

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			set.add(arr[i]);

		}

		return set.size();

	}

}
