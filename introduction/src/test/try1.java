package test;
import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt(),sum=1;
		for(int i=1;i<=n;i++) {
			sum*=i;
		}
		System.out.println(sum);
		scan.close();
	}
}
