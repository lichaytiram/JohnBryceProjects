import java.util.Scanner;

public class try16 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1=scan.nextInt(),n2=scan.nextInt(),sum=0;
		while(n2>0) {
			sum+=n1;
			n2-=1;
		}
		System.out.println(sum);
		scan.close();
	}
}
