package Program28;
import java.util.Scanner;

public class try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max=scan.nextInt(),den=scan.nextInt();
		while(max<=0)
			max=scan.nextInt();
		while(den<=0)
			den=scan.nextInt();
		
		for(int i=0;i<=max;i++) {
			if(i%den==0)
				System.out.println(i);
		}
		
		
		scan.close();
	}

}
