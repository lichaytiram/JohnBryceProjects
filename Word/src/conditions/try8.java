package conditions;

import java.util.Scanner;

public class try8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		System.out.println(x/100+" And "+(x/10)%10+" And "+x%10);
		scan.close();
	}
}
