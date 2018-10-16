package page6;

import java.util.Scanner;

public class ex6try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = (int) (Math.random() * 101);
		for(int i=0;i<=x;i++)
			System.out.println(i);
		
		
		
		scan.close();
	}
}
