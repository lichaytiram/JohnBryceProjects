package codility;

public class FrogRiverOne {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 3, 1, 5, 4, 2, 3, 5, 4 }));
	}

	public static int solution(int x, int[] arr) {

		if (arr == null || arr.length == 0)
			return -1;

		for (int i = 0; i < arr.length; i++)
			if (arr[i] == x)
				return i;

		return -1;
	}

}
