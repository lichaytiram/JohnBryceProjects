import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("choose from menu by key 1-4 ");
		int n1 = scan.nextInt(), n2 = scan.nextInt();
		switch (n1) {
		case 1:
			System.out.println(n2 * n2);
			break;
		case 2:
			int sum = 1;
			for (int i = 1; i <= n2; i++) {
				sum *= i;
			}
			System.out.println(sum);
			break;
		case 3:
			if (n2 > 0)
				System.out.println("positive");
			else
				System.out.println("negative");
			break;
		case 4:
			System.out.println("Bye Bye");
			break;
		}

		scan.close();
	}

}
