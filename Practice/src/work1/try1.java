package work1;

import java.util.Scanner;

public class try1 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int n1=scan.nextInt(),n2=scan.nextInt();
		terrain(n1,n2);
		System.out.print("Enter a number: ");
		int n3=scan.nextInt();
		System.out.println(reverse(n3));
		System.out.print("Enter text and number ");
		String s=scan.next();
		int n4=scan.nextInt();
		doNum(s,n4);
		
		scan.close();
	}
	public static void terrain(int x,int y) {
		if(x>y) {
			int temp=x;
			x=y;
			y=temp;
		}
		for(int i=x;i<=y;i++) {
			if(i%3==0 || i%5==0)
				System.out.println(i);
		}
		
	}
	public static int reverse(int x) {
		int sum=0;
		while(x>0) {
			sum*=10;
			sum+=x%10;
			x/=10;
		}
		return sum;
	}
	public static void doNum(String s,int num) {
		for(int i=0;i<num;i++) {
			System.out.print(s+" ");
		}
		
	}

}
