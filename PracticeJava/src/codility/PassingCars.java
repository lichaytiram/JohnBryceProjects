package codility;

public class PassingCars {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 0, 1, 0, 1, 1 }));
	}

	public static int solution(int[] arr) {

		long countPair = 0, howMuchZero = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				howMuchZero++;
			else
				countPair += howMuchZero;
		}

		if (countPair <= 1000000000)
			return (int) countPair;
		return -1;
	}

}
