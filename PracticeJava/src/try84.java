
public class try84 {
	public static void main(String[] args) {

		System.out.println(betweenExtremes(new int[] { 2, 4, 75, 45, 5578 }));
	}

	public static int betweenExtremes(int[] numbers) {
		int max = numbers[0], min = numbers[0];

		for (int i = 0; i < numbers.length; i++) {
			if (max < numbers[i])
				max = numbers[i];
			if (min > numbers[i])
				min = numbers[i];

		}
		return max - min;
	}
}
