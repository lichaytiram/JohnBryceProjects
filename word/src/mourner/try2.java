package mourner;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1=scan.nextInt(),n2=scan.nextInt();
		if(n1==n2)
			System.out.println("even");
		else if(n1>n2)
			System.out.println(n1);
		else
			System.out.println(n2);
		scan.close();
	}
}
