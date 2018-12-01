package page33;
import java.util.Scanner;

public class try14 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x=scan.nextInt();
		for(int i=1;i<=5;i++) {
			int num=scan.nextInt();
			if(num==x)
				System.out.println(i);
		}
		
		scan.close();
	}
}
