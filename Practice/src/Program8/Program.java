package Program8;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println(car1);
		System.out.println("how much speed you want?");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		for (int i = 0; i < x; i++) {
			car1.gaz();
		}
		System.out.println(car1);
		car1.slow();
		car1.slow();
		System.out.println(car1);
		car1.stop();
		System.out.println(car1);
		
		
		scan.close();
	}
}
