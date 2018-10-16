
public class try13 {
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		double grade = scan.nextInt(), sum = scan.nextInt(), countS = scan.nextInt();
		if (countS <= 4)
			System.out.println("Sorry ,but you fail in test (F)");
		else if (countS <= 6) {
			if (grade < 55)
				System.out.println("Your grade is " + grade + " next time learn!");
			else {
				sum = sum * 0.2;
				if (grade < sum)
					grade += sum;
				else
					grade -= sum;
				System.out.println("Your grade is " + grade);

			}
		}

		scan.close();
	}
}
