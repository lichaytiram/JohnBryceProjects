package Program28;
import java.util.Scanner;

public class try8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max = 0;
		for (int i = 1; i <= 100; i++) {
			int num = (int) (Math.random() * 100);
			if (num > max)
				max = i;

		}
		System.out.println("The biggest number is " + max);

		scan.close();
	}
}
