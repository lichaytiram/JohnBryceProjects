import java.util.Scanner;

public class try11 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x=scan.nextInt();
		System.out.println(Breverse(x));
		scan.close();
	}

	public static int Breverse(int sum) {
		int sumX = sum;
		while (sum > 0) {
			sumX *= 10;
			sumX += sum % 10;
			sum /= 10;
		}

		return sumX;
	}
}
