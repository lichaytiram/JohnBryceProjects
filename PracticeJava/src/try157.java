
public class try157 {

	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
	}

	public static int solution(int x, int y, int d) {

		int jump = 0;
		y = y - x;
		if (y % d != 0)
			jump = y / d + 1;
		else
			jump = y / d;

		return jump;
	}

}
