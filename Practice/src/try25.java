
public class try25 {
	public static void main(String[] args) {
		System.out.println(isSquare(25));
	}

	public static boolean isSquare(int n) {
		if (Math.sqrt(n) == (int) Math.sqrt(n))
			return true;
		return false;
	}
}
