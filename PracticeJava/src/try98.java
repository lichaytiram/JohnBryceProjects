
public class try98 {
	public static void main(String[] args) {
		System.out.println(breakChocolate1(5, 5));
		System.out.println(breakChocolate2(5, 5));
	}

	public static int breakChocolate1(int n, int m) {
		if (m * n == 0)
			return 0;
		return n * m - 1;
	}

	public static int breakChocolate2(int n, int m) {
		return n * m > 0 ? n * m - 1 : 0;
	}
}
