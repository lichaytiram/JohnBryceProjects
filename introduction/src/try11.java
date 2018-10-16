import java.util.Scanner;

public class try11 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(), count = 0;
		while (num > 0) {
			count++;
			num = num / 10;

		}
		System.out.println(count);

		scan.close();
	}
}
