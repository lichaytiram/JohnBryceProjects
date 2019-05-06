
public class try152 {

	public static void main(String[] args) {
		System.out.println(isBalance(new int[] { 2, 4, 3, 8 }));
	}

	public static boolean isBalance(int[] arr) {

		if (arr == null)
			return false;

		int start = 0, end = 0, startI = 0, endI = arr.length - 1;

		while (startI <= endI) {
			if (start > end) {
				end += arr[endI];
				endI--;
			} else {
				start += arr[startI];
				startI++;
			}

		}
		if (start == end)
			return true;
		return false;

	}

}
