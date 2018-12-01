package Program28;
import java.util.Scanner;

public class try10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt(),sum=0;
		while(num>10) {
			sum+=num%10;
			num=num/10;
		}
		System.out.println(sum+num);
		
		scan.close();
	}
}
