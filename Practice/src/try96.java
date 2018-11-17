
public class try96 {
	public static void main(String[] args) {
		print1(7, 4);
		print2(4, 7);
		print3(7, 7);

	}

	public static void print1(int n1, int n2) {
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++)
				if (i == 0 || j == 0 || i == n1 - 1 || j == n2 - 1 || i == n1 / 2)
					System.out.print('*');
				else
					System.out.print(' ');
			System.out.println();
		}
		System.out.println();
	}

	public static void print2(int n1, int n2) {

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++)
				if (i == n1 - 1 || n2 / 2 == j || i == 0)
					System.out.print('*');
				else
					System.out.print(' ');
			System.out.println();
		}
		System.out.println();
	}

	public static void print3(int n1, int n2) {

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++)
				if (i == n1 - 1 || j == n2 - 1 || j == n1 - 1 - i)
					System.out.print('*');
				else
					System.out.print(' ');
			System.out.println();
		}
		System.out.println();
	}
}
