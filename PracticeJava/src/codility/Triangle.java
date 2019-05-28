package codility;

public class Triangle {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 20 }));
	}

	public static int solution(int[] arr) {

		if (arr == null || arr.length <= 2)
			return 0;

//		for (int i = 0; i < arr.length - 2; i++) {
//
//			if (arr[i] + arr[i + 1] > arr[i + 2] && arr[i + 1] + arr[i + 2] > arr[i]
//					&& arr[i + 2] + arr[i] > arr[i + 1])
//				return 1;
//
//		}

		return 0;
	}
}
