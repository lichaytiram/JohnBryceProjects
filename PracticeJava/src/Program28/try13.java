package Program28;
import java.util.Scanner;

public class try13 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int entire = scan.nextInt(), help = 0;
		while (entire > 0) {
			help = entire % 10;
			System.out.print(help);
			entire = entire / 10;
		}

		scan.close();
	}
}
