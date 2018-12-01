
public class try16 {

	public static void main(String[] args) {
		System.out.println(isDivisible(6,3,2));
	}

	public static boolean isDivisible(long n, long x, long y) {
		if (n % x == 0 && n % y == 0)
			return true;
		return false;
	}
}
