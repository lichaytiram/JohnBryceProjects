
public class try14 {
	public static void main(String[] args) {
		long x = persistence(4);
		System.out.println(x);

	}

	public static int persistence(long n) {
		int count = 0;
		while (n > 9) {
			count++;
			n = doIt(n);
		}

		return count;
	}

	public static long doIt(long n) {
		int sum = 1;
		while (n > 0) {
			sum *= n % 10;
			n /= 10;
		}
		return sum;
	}

}
