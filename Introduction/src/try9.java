import java.util.Scanner;

public class try9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		while(num>10) {
			num=num/10;
		}
		System.out.println(num);
		
		scan.close();
	}
}
