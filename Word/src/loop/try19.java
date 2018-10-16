package loop;

import java.util.Scanner;

public class try19 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int min=scan.nextInt(),max=scan.nextInt(),count=0;
		for(int i=min;i<=max;i++) {
			if(i%3==0) {
				count++;
				System.out.println(i);
			}
			if(i%7==0) {
				count++;
				System.out.println(i);
			}
		}
		
		System.out.println("numbers divide is "+count);
		
		scan.close();
	}
}
