package codility;

public class FrogRiverOne {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 3, 1, 5, 4, 2, 3, 5, 4 }));
	}

	public static int solution(int x, int[] arr) {

		int index = -1;

		if (arr == null || arr.length == 0)
			return index;

		for (int i = 0; i < arr.length; i++)
			if (arr[i] == x)
				index = i;

		return index;
	}

}
