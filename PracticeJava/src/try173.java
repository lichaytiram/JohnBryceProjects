import java.util.Arrays;

public class try173 {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 5, 4, 2, 1, 0 };

		System.out.println(Arrays.toString(arr));
		sort(arr, 0);
		System.out.println(Arrays.toString(arr));

	}

	public static void sort(int[] arr, int index) {

		if (arr == null || arr.length == 0 || index == arr.length - 1)
			return;

		int tempIndex = index, min = arr[tempIndex], indexForReplace = index;

		while (tempIndex < arr.length) {
			if (arr[tempIndex] < min) {
				min = arr[tempIndex];
				indexForReplace = tempIndex;
			}
			tempIndex++;
		}

		arr[indexForReplace] = arr[index];
		arr[index] = min;

		sort(arr, ++index);

	}

}
