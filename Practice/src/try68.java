
public class try68 {
	public static void main(String[] args) {
		System.out.println(special(89));
	}

	public static boolean special(int x) {
		int number = 0, temp = x, count = 0;
		while (x > 0) {
			count++;
			x /= 10;
		}
		x = temp;

		for (int i = count; i > 0; i--) {
			number += Math.pow(x % 10, i);
			x /= 10;

		}

		if (number == temp)
			return true;
		return false;
	}

}
