import java.util.Scanner;

public class try8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int bigN = scan.nextInt(), d = scan.nextInt(), count = 0;
		while (bigN > 0) {
			if (bigN % 10 == d)
				count++;
			bigN /= 10;
		}
		System.out.println("Have " + count + " times");

		scan.close();
	}

}
