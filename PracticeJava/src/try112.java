
public class try112 {
	public static void main(String[] args) {
		System.out.println(digPow(695, 2));
	}

	public static long digPow(int n, int p) {
		if (n <= 0)
			return -1;
		int sum = 0, tempNum = n, count = 0;
		while (tempNum > 0) {
			tempNum /= 10;
			count++;
		}
		tempNum = n;
		p = p - 1 + count;
		for (int i = 1; i <= count; i++) {
			sum += Math.pow(tempNum % 10, p);
			p--;
			tempNum /= 10;

		}
		if (sum < n || sum % n != 0)
			return -1;
		return sum / n;
	}
}
