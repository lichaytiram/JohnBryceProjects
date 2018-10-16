
public class try35 {
	public static void main(String[] args) {
		System.out.println(sumOfAngles(3));
	}

	public static int sumOfAngles(int n) {
		double sum = Math.round((((1 - 2 / (double) n) * 180) * n));
		return (int) sum;
	}
}
