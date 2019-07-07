import java.util.Arrays;

public class try173 {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 5, 4, 2, 1, 0 };

		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	public static void sort(int[] arr, int startIndex, int endIndex) {

		if (arr == null || arr.length == 0)
			return;

		if (startIndex >= endIndex)
			return;

		if (arr[startIndex] > arr[endIndex]) {
			int temp = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = temp;
			sort(arr, ++startIndex, endIndex);
		} else
			sort(arr, startIndex, endIndex);

	}
}
