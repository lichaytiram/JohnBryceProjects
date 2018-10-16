import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println(num);
		if (num < 10) {
			System.out.println("number 1");
		} else if (num < 100)
			System.out.println("number 2");
		else if (num < 1000)
			System.out.println("number 3");
		else
			System.out.println("number 4");

		scan.close();
	}

}
