import java.util.Arrays;

public class try165 {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 5, 2 };

		System.out.println(Arrays.toString(arr));
		reverseRecursive(arr, 0);
		System.out.println(Arrays.toString(arr));

	}

	public static void reverseRecursive(int[] arr, int index) {

		if (arr == null || arr.length < 2)
			return;

		if (index >= arr.length / 2)
			return;

		int value = arr[index];
		int endIndex = arr.length - 1 - index;
		arr[index] = arr[endIndex];
		arr[endIndex] = value;

		reverseRecursive(arr, ++index);

	}

}
