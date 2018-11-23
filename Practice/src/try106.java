import java.util.Arrays;

public class try106 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		arr = sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] sort(int[] arr) {
		Arrays.sort(arr);
		int[] newarr = new int[arr.length];
		int start = 0, end = arr.length - 1;
		for (int i = 0; i < newarr.length; i++) {
			if (i % 2 == 0) {
				newarr[i] = arr[start];
				start++;
			} else {
				newarr[i] = arr[end];
				end--;
			}
		}
		return newarr;
	}
}
