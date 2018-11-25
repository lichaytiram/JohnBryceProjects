package Program28;
import java.util.Scanner;

public class try15 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(), ret = 0,pol=num;
		while (num > 0) {
			ret *= 10;
			ret += num % 10;
			num /= 10;
		}
		if(ret==pol)
			System.out.println("polinedrum");
		System.out.println(ret);

		scan.close();
	}
}
