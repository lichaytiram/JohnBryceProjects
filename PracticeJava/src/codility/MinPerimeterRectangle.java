package codility;

public class MinPerimeterRectangle {

	public static void main(String[] args) {

		System.out.println(solution(30));

	}

	public static int solution(int n) {

		int minArea = 2 * (1 + n);

		for (int i = 1; i < n / 2; i++) {
			if (n % i == 0 && i * (n / i) == n && 2 * (i + n / i) < minArea)
				minArea = 2 * (i + n / i);
		}

		return minArea;

	}

}
