
public class try169 {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 3, 4 };
		System.out.println(binarySearch(arr, 0, arr.length - 1, 2));

	}

	public static boolean binarySearch(int[] arr, int leftIndex, int rightIndex, int wanted) {

		if (arr == null)
			return false;

		if (leftIndex > rightIndex)
			return false;

		int mid = (leftIndex + rightIndex) / 2;
		if (wanted == arr[mid])
			return true;

		if (arr[mid] > wanted)
			rightIndex = mid - 1;
		else
			leftIndex = mid + 1;

		return binarySearch(arr, leftIndex, rightIndex, wanted);

	}

}
