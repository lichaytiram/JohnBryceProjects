package Day23_03_2019_complexity;

public class ExerciseDown2 {

	public static void main(String[] args) {
		System.out.println(isBalance(new int[] { 1, 2, 3 }));
	}

	public static String isBalance(int[] arr) {

		int sum = 0, halfSum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if (sum != 0)
			sum /= 2;

		for (int i = 0; i < arr.length; i++) {
			halfSum += arr[i];

			if (halfSum == sum)
				return "This is balance";
		}

		return "This isn't balance";
	}
}
