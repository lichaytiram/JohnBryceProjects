
public class try38 {
	public static void main(String[] args) {

		int[] arr = { 2, 2, 2, 2,7 };
		System.out.println(stray(arr));

	}

	public static int stray(int[] numbers) {

		if (numbers[0] != numbers[1] && numbers[0] != numbers[2])
			return numbers[0];
		int check = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (check != numbers[i])
				return numbers[i];
		}
		return -1;
	}
}
