import java.util.Scanner;

public class try18 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), count = 0;
		while (n1 >= n2) {
			count++;
			if (n1 == n2)
				System.out.println(count);
			n1 -= n2;
			if (n1 < n2)
				System.out.println("sherit " + n1);
			
		}
		scan.close();
	}
}
