import java.util.Scanner;

public class Protein {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter two numbers to calculate");
		long n1 = scan.nextLong(), n2 = scan.nextLong();
		System.out.println(calculateProtein(n1, n2));

	}

	public static String calculateProtein(long n1, long n2) {

		long sum1 = n1, sum2 = n2;
		long count1 = 1, count2 = 1;

		while (sum1 != sum2) {
			if (sum1 < sum2) {
				sum1 += n1;
				count1++;
			} else {
				sum2 += n2;
				count2++;
			}
		}

		return "values: " + n1 + "-" + count1 + " || " + n2 + "-" + count2;
	}

}
