import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		while (x >= 0) {
			int sum = 1;
			for (int i = 1; i <= x; i++) {
				sum *= i;
			}
			System.out.println(sum);
			x = scan.nextInt();
		}

		scan.close();
	}
}
