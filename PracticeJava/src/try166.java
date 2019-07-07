
public class try166 {

	public static void main(String[] args) {

		triangleRecursive(1, 5);

	}

	public static void triangleRecursive(int start, int end) {

		if (start > end)
			return;
		printTriangleRecursive(start);
		System.out.println();

		triangleRecursive(++start, end);

	}

	private static void printTriangleRecursive(int number) {

		if (number <= 0)
			return;

		if (number > 0)
			System.out.print("*");

		printTriangleRecursive(--number);
	}

}
