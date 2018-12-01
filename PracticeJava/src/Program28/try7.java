package Program28;
import java.util.Scanner;

public class try7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(), min = num;
		while(num>0) {
			if(num<min)
				min=num;
			num = scan.nextInt();
		}
		System.out.println(min);
		
		scan.close();
	}
}
