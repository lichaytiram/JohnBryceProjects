
public class try20 {
	public static void main(String[] args) {
		int[] arr = { -1, 2, -3, 4, -5 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		invert(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static int[] invert(int[] array) {
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			array[i] *= -1;
		}
		return array;
	}

}
