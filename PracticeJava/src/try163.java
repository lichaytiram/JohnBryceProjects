
public class try163 {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 2, 3, 0, 2 };

		System.out.println(sumRecursive(arr, arr.length - 1));

	}

	public static int sumRecursive(int[] arr, int right) {

		if (arr == null)
			return 0;

		if (right == 0)
			return arr[right];

		return sumRecursive(arr, right - 1) + arr[right];

	}

}