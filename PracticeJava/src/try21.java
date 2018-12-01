
public class try21 {
	public static void main(String[] args) {
		System.out.println(factorial(2));
	}

	public static int factorial(int n) {
		int sum = 1;
		if (n > 12 || n < 0)
			throw new IllegalArgumentException("bad percent");
		while (n > 1) {
			sum *= n;
			n--;
		}
		return sum;
	}
}
