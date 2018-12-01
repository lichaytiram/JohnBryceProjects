
public class try93 {
	public static void main(String[] args) {
		System.out.println(compute(12, 6));

	}

	public static int compute(int x, int y) {
		int temp, digit = 0;
		if (x > y)
			temp = y;
		else
			temp = x;
		for (int i = temp; i > 0; i--)
			if (x % i == 0 && y % i == 0) {
				digit = i;
				break;
			}
		return digit;
	}
}
