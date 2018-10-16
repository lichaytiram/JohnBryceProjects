
public class try48 {
	public static void main(String[] args) {
		System.out.println(PD(22, 14));

	}

	public static int PD(int num1, int num2) {
		int sum1 = sumPrime(num1), sum2 = sumPrime(num2);
		sum1 = fixPrime(sum1, num1);
		sum2 = fixPrime(sum2, num2);
		sum1 = divided(sum1);
		sum2 = divided(sum2);
		return result(sum1, sum2);
	}

	public static int result(int sum1, int sum2) {
		int maxNumber = 0;
		for (int i = sum1; i > 0; i--) {
			if (sum1 % i == 0 && sum2 % i == 0) {
				return maxNumber = i;
			}
		}
		return maxNumber;
	}

	public static int divided(int num) {
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				sum += i;
		}
		return sum;
	}

	public static int fixPrime(int fix, int sum) {
		boolean check = false;
		for (int i = 2; i < fix; i++) {
			if (fix % i == 0)
				check = true;
			if (check == true)
				return fix;
		}
		int less = 0;
		for (int i = 2; i < sum; i++) { // always -13
			if (sum % i != 0)
				less = i;
		}

		return fix = fixPrime(fix - less, less);

	}

	public static int sumPrime(int num) {
		if (num == 2)
			return 2;
		int sum = 0;
		for (int i = 2; i <= num; i++) {
			if (i == 2)
				sum += 2;
			else
				for (int j = 2; j < i; j++) {
					if (i % j == 0)
						break;
					if (j == i - 1)
						sum += i;
				}

		}
		return sum;
	}
}
