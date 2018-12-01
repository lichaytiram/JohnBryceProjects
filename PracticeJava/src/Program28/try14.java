package Program28;
import java.util.Scanner;

public class try14 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int entire = scan.nextInt(), help = 0, root = -1, check = entire,pol=entire;
		while (check > 0) {
			root++;
			check = check / 10;
		}
		while (root >= 0) {
			help += (entire % 10) * (Math.pow(10, root));
			entire = entire / 10;
			root = root - 1;
		}
		if(help==pol)
			System.out.println("polinderum");
		System.out.println(help);

		scan.close();
	}
}
