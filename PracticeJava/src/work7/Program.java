package work7;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number between [1 to 4]\n1-Rectangle\n2-Circle\n3-Triangle\n4-Exit");
		int x = scan.nextInt(), count = 0;
		Shape s;
		Shape[] arr = new Shape[5];
		while (count < 5) {
			switch (x) {
			case 1:
				s = new Rectangle(2, 2, true, "blue", 4, 6);
				arr[count] = s;
				System.out.println(s);
				break;
			case 2:
				s = new Circle(2, 2, true, "red", 3);
				arr[count] = s;
				System.out.println(s);
				break;
			case 3:
				s = new Triangle(8, 8, true, "white", 6, 6);
				arr[count] = s;
				System.out.println(s);
				break;
			case 4:
				System.out.println("Bye Bye...");
				count = 4;
				break;
			default:
				count=4;
				System.out.println("Error");
				break;
			}
			if (count < 4) {
				System.out.println(
						"\nEnter a another number between [1 to 4]\n1-Rectangle\n2-Circle\n3-Triangle\n4-Exit");
				x = scan.nextInt();
			}
			count++;
		}
		 System.out.println("This "+ arr[0]);
		scan.close();
	}
}
