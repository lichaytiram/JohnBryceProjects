import java.util.Arrays;

public class try90 {
	public static void main(String[] args) {
		System.out.println(maxNumber(15834824));

	}

	public static long maxNumber(long n) {
		long temp = 0;
		int[] arr = new int[numOfDigits(n)];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (n % 10);
			n /= 10;
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			temp *= 10;
			temp += arr[arr.length - 1 - i];

		}
		return temp;
	}

	public static int numOfDigits(long n) {
		int sum = 0;
		while (n > 0) {
			sum++;
			n /= 10;

		}
		return sum;
	}
}
