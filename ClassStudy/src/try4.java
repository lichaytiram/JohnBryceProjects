import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		fact(x);
		entire(5, 8);

		scan.close();
	}

	public static void fact(int x) {
		int sum = 1;
		for (int i = 2; i <= x; i++) {
			sum *= i;
		}
		System.out.println(sum);
	}

	public static void entire(int n1, int n2) {
		if (n1 < n2)
			for (int i = n1; i <= n2; i++) {
				System.out.print(i + " ");
			}
	}

}
