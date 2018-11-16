import java.util.Arrays;

public class try85 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new int[] { 10, 0 })));
	}

	public static int[] sort(final int[] array) {
		Arrays.sort(array);
		return array;
	}
}
