package Program28;
import java.util.Scanner;

public class try6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(), max = 0;
		while(num>0) {
			if(num>max)
				max=num;
			num = scan.nextInt();
		}
		System.out.println(max);
		
		scan.close();
	}
}
