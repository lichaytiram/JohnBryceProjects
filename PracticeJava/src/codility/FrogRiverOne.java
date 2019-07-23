package codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 3, 1, 5, 4, 2, 3, 5, 4 }));
	}

	public static int solution(int x, int[] arr) {

		if (arr == null || arr.length == 0)
			return -1;

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] <= x)
				set.add(arr[i]);

			if (set.size() == x)
				return i;
		}

		return -1;

	}

}
