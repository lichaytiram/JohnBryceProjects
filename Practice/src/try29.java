
public class try29 {
	public static void main(String[] args) {
		System.out.println(sumTriangularNumbers(1));
	}

	public static int sumTriangularNumbers(int n) {
		int sum = 0, count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				count++;
				if (j == i)
					sum += count;
			}
		}
		return sum;
	}
}
