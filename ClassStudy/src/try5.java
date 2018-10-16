import java.util.Scanner;

public class try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		num = absolute(num);
		System.out.println(primary(num));
		
		
		scan.close();
	}
	public static int absolute(int x) {
		if(x<0)
			x*=-1;
		return x;
	}
	public static boolean primary(int x) {
		boolean B=false;
		for(int i=2;i<x;i++) {
			if(x%i==0)
				B=true;	
		}
		return B;
	}
}
