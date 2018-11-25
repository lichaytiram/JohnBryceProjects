package page37;
import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int summax=0;
		for(int i=1;i<=100;i++) {
			System.out.println("number student "+i);
			int sum=0;
			for(int j=0;j<10;j++) {
				int grade=scan.nextInt();
				sum+=grade;
			}
			System.out.println(sum/10);
			summax+=sum;
		}
		System.out.println(summax/1000);
		
		scan.close();
	}
}
