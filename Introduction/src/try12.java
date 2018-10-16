import java.util.Scanner;

public class try12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), dig = scan.nextInt(), count = 0;
		while (x > 0) {
			if (x % 10 == dig)
				count++;
			x = x / 10;
		}
		System.out.println(count);

		scan.close();
	}
}
