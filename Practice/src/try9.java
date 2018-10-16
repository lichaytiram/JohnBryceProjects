import java.util.Scanner;

public class try9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), count = 0;
		if (countN(n1) == countN(n2)) {
			while (n1 > 0) {
				if (n1 % 10 == n2 % 10)
					count++;
				n1 /= 10;
				n2 /= 10;
			}
			System.out.println(count);
		} else
			System.out.println("The length isn't equal");

		scan.close();

	}

	public static int countN(int n) {
		int count = 0;
		while (n > 0) {
			count++;
			n /= 10;
		}
		return count;
	}

}
