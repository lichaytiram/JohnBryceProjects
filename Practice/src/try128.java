import java.util.Arrays;

public class try128 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				countPositivesSumNegatives(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15 })));

	}

	public static int[] countPositivesSumNegatives(int[] input) {
		if (input == null || input.length == 0)
			return new int[] { 0, 0 };
		int[] temp = new int[2];
		int count = 0, countSum = 0;
		for (int i = 0; i < input.length; i++)
			if (input[i] > 0)
				count++;
			else if (input[i] < 0)
				countSum += input[i];
		temp[0] = count;
		temp[1] = countSum;
		return temp;
	}
}
