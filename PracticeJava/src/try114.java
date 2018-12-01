
public class try114 {
	public static void main(String[] args) {
		System.out.println(digital_root(493193));

	}

	public static int digital_root(int n) {
		while (n > 9) {
			int sum = 0;
			while (n > 0) {
				sum += n % 10;
				n /= 10;
			}
			n = sum;
		}
		return n;
	}
}
