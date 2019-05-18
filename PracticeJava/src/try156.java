import java.util.Arrays;

public class try156 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 2, 5, 4, 6, 1 }, 1)));
	}

	public static int[] solution(int[] arr, int k) {

		if (arr == null || arr.length == 0)
			return arr;

		while (k > 0) {
			changePlace(arr);
			k -= 1;
		}

		return arr;

	}

	public static void changePlace(int[] arr) {

		int digit = arr[arr.length - 1];

		for (int i = arr.length - 1; i > 0; i--)
			arr[i] = arr[i - 1];

		arr[0] = digit;

	}

}
