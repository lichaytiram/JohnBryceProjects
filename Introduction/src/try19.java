import java.util.Scanner;

public class try19 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt(),sum=1;
		while(num>0) {
			sum*=num;
			num-=1;
		}
		System.out.println(sum);
		
		scan.close();
	}
}
