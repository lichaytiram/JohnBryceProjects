package codility;

public class CountFactors {

	public static void main(String[] args) {
		System.out.println(solution1(39992976));
//		System.out.println(solution2(39992976));
	}

	public static int solution1(int n) {

		int count = 0;

		for (int i = 1; i <= Math.abs(n); i++) {
			if (n % i == 0)
				count++;
		}
		return count;
	}

//	public static int solution2(int n) {
//
//		return mySolution(n, n);
//
//	}
//
//	public static int mySolution(int n, int tempN) {
//		if (tempN == 0)
//			return 0;
//
//		if (n % tempN == 0)
//			return 1 + mySolution(n, tempN - 1);
//
//		return mySolution(n, tempN - 1);
//	}

}
