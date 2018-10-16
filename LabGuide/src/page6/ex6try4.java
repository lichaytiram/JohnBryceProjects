package page6;

import java.util.Scanner;

public class ex6try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max = (int) (Math.random() * 101),den = (int) (Math.random() * 50);
		for(int i=0;i<=max;i++)
			if(i%den==0)
				System.out.println(i);
		
		System.out.println("max is "+max+" den is "+ den);
		scan.close();
	}
}
