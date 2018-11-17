import java.util.Arrays;

public class try92 {
	public static void main(String[] args) {
		System.out.println(smallEnough(new int[] { 3, 6, 1, 4 }, 5));
	}

	public static boolean smallEnough(int[] a, int limit) {
		Arrays.sort(a);
		return a[a.length - 1] <= limit;
	}
}
