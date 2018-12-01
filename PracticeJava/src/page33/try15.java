package page33;

import java.util.Scanner;

public class try15 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0, count = 0;
		for(int i=0;i<5;i++) {
			String name = scan.next();
			int grade=scan.nextInt();
			if(grade>70) {
				System.out.println(name);
				sum+=grade;
				count++;
			}
		}
		if(count==0)
			System.out.println("all fail");
		else
			System.out.println(sum/count);
		
		
		scan.close();
	}
}
