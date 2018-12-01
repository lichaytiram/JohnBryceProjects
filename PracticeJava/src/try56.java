
public class try56 {
	public static void main(String[] args) {
		int[] num = { 2, 12, 8, 4, 6 };
		System.out.println(minimumNumber(num));
	}

	public static int minimumNumber(int[] numbers) {
		int minimumNumber = 0, sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		while (prime(sum) == false) {
			minimumNumber++;
			sum++;
		}

		return minimumNumber;
	}

	public static boolean prime(int num) {
		for (int i = 2; i < num; i++)
			if (num % i == 0)
				return false;
		return true;
	}
}
