
public class try123 {
	public static void main(String[] args) {
		System.out.println(isLucky(189237));
	}

	public static boolean isLucky(long n) {
		long temp = n, count = 0, sum = 0;
		while (temp > 0) {
			count++;
			temp /= 10;
		}
		for (int i = 0; i < count; i++) {
			sum += n % 10;
			n /= 10;
		}
		return sum % 9 == 0 ? true : false;
	}
}
