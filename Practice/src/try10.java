import java.util.Scanner;

public class try10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), count = count(x), sum = 0;
		if (count % 2 == 0) {
			int Z = 0;
			sum = (change(x, Z));
			sum = reverse(sum);
		} else {
			int Z = 10;
			sum = (change(x, Z));
			sum = reverse(sum);
		}
		System.out.println(sum);
		scan.close();
	}

	public static int count(int x) {
		int count = 0;
		while (x > 0) {
			count++;
			x /= 10;
		}
		return count;
	}

	public static int change(int x, int y) {
		int sum = 0, temp;
		while (x > y) {
			temp = x % 10;
			x /= 10;
			sum *= 10;
			sum += x % 10;
			sum *= 10;
			sum += temp;
			x /= 10;
			if (x < 10 && x > 0) {
				sum *= 10;
				sum += x % 10;
			}

		}
		return sum;
	}

	public static int reverse(int sum) {
		int sumX = 0;
		while (sum > 0) {
			sumX *= 10;
			sumX += sum % 10;
			sum /= 10;
		}

		return sumX;
	}
}
