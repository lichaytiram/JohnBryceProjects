
public class try22 {
	public static void main(String[] args) {
		System.out.println(calculateYears(1000, 0.05, 0.18, 1100));
	}

	public static int calculateYears(double principal, double interest, double tax, double desired) {
		int year = 0;
		while (principal < desired) {
			year++;
			double temp = principal * interest;
			principal+=temp;
			principal-=temp*tax;
		}
		return year;
	}
}
