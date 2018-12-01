package LabGuidePage8;

import java.util.Scanner;

public class ex7try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		double sum=0;
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(int)(Math.random()*101);
			sum+=arr[i];
		}
		System.out.println("The total sum is "+ sum+ " and average is "+sum/arr.length);
		scan.close();
	}
}