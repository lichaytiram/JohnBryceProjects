import java.util.Arrays;

public class try129 {
	public static void main(String[] args) {

		System.out.println(findSmallestInt(new int[] { 78, 56, 232, 12, 11, 43 }));
	}

	public static int findSmallestInt(int[] args) {
		Arrays.sort(args);
		return args[0];
	}
}
