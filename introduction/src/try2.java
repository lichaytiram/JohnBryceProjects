import java.util.Scanner;

public class try2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double num = scan.nextDouble();
		if (num % 2 == 0) {
			num = num + 2;
			System.out.println(num);
		} else {
			num = (int) num + 1;
			if (num % 2 == 0)
				System.out.println(num);
			else {
				num++;
				System.out.println(num);
			}
		}

		scan.close();

	}

}
