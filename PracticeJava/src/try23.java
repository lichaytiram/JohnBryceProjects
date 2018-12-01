
public class try23 {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 3, 9, 8 };
		System.out.println(find_average(arr));
	}

	public static double find_average(int[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		sum /= array.length;
		return sum;
	}

}
