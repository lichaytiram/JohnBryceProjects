
public class try174 {

	public static void main(String[] args) {

		printTriangular(5);
	}

	public static void printTriangular(int number) {

		if (number == 0)
			return;

		printTriangular(number - 1);

		printer(number);
		System.out.println();

	}

	
	private static void printer(int number) {

		if (number == 0)
			return;

		System.out.print("*");
		printer(--number);

	}
}
