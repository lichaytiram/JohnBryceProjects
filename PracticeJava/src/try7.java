import java.util.Scanner;

public class try7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a char");
		char x = scan.next().charAt(0), y = x, z = x;
		while (x != 1 + y || x != 2 + z) {
			System.out.println("Enter a char");
			z = y;
			y = x;
			x = scan.next().charAt(0);
		}
		System.out.println(x + " ," + y + "," + z);
		scan.close();
	}
}
