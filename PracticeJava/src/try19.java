
public class try19 {
	public static void main(String[] args) {
		System.out.println(GetSum(1, 1));
	}

	public static int GetSum(int a, int b) {
		int sum = 0, in = 1;
		if (a > b)
			in *= -1;

		for (int i = a; i != b; i += in) {
			sum += i;
		}
		sum += b;
		return sum;
	}
}
