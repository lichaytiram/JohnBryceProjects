import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while (n % 2 == 0)
			n = scan.nextInt();
		for (int i = 0; i < (n + 1) / 2; i++) {
			System.out.println();
			for (int j = 1; j <= n; j++) {
				if ((j + i) < (n + 1) / 2 || (j - i) > (n + 1) / 2)
					System.out.print(" ");
				else
					System.out.print("*");
			}
		}
		scan.close();
	}
}
