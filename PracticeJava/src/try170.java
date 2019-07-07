
public class try170 {

	public static void main(String[] args) {

		System.out.println(sum(1822));
	}

	public static int sum(int number) {

		if (number == 0)
			return 0;

		return number % 10 + sum(number / 10);

	}
}
