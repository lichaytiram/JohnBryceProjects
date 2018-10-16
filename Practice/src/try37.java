
public class try37 {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };
		System.out.println(cubeOdd(arr));

	}

	public static int cubeOdd(int arr[]) {
		int[] arrNew = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0)
				arrNew[i] += arr[i];
		}
		for (int i = 0; i < arrNew.length; i++) {
			arrNew[i] = (int) (Math.pow(arrNew[i], 3));
		}
		int sum = 0;
		for (int i = 0; i < arrNew.length; i++) {
			sum += arrNew[i];
		}
		return sum;
	}

}
