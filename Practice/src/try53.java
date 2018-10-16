
public class try53 {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 2, 8, 1, 4 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(sortArray(arr)[i] + " ");
		}
	}

	public static int[] sortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0)
				for (int j = i; j < array.length; j++) {
					if (array[j] % 2 != 0 && array[i] > array[j]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
		}
		return array;
	}
}
