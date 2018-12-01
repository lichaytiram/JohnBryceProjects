package Program28;
import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		int x = scan.nextInt();
		System.out.println(name);
		if (((x * 10) / 100 + x) < 6000)
			System.out.println((x * 10) / 100 + x);
		else
			System.out.println((x * 5) / 100 + x);
		scan.close();
	}

}
