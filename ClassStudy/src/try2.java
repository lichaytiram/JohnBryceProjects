import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), index;
		if (n1 < n2)
			index = 1;
		else
			index = -1;
		for (int i = n1; i != n2; i += index)
			System.out.println(i);
		System.out.println(n2);
		scan.close();
	}
}
