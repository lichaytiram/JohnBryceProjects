
public class try27 {
	public static void main(String[] args) {
		System.out.println(numberOfDivisors(6));
	}

	public static long numberOfDivisors(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				count++;
		}
		return count;
	}
}
