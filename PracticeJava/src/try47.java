
public class try47 {
	public static void main(String[] args) {

			System.out.println(isPerfectPower(8)[0]+" , "+isPerfectPower(8)[1]);
		
	}

	public static int[] isPerfectPower(int n) {
		int x = 0, y = 0;
		for (int i = 1; i <= n / 2; i++) {
			for (int j = 2; j <= n / 2; j++) {
				if (Math.pow(i, j) == n) {
					x = i;
					y = j;
					break;
				}
			}
			if (x != 0 || y != 0)
				break;
		}

		if (x == 0 || y == 0)
			return null;
		return new int[] { x, y };
	}

}
