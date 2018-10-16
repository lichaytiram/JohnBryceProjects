
public class try26 {
	public static void main(String[] args) {
		int[] arr = { 5, 8, 2, 4 };
		for (int i = 0; i < 2; i++) {
			System.out.print(minMax(arr)[i] + " ");

		}
	}

	public static int[] minMax(int[] arr) {
		int max = arr[0], min = arr[0];
		int[] minMax = new int[2];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		minMax[0] = min;
		minMax[1] = max;
		return minMax;
	}
}
