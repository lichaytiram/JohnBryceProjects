
public class try32 {
	public static void main(String[] args) {
		int[] arr = { 3, -55, 72 };
		System.out.println(findLongest(arr));
	}

	public static int findLongest(int[] numbers) {
		int max = 0, biggerD = 0;
		for (int i = 0; i < numbers.length; i++) {
			int count = 0, temp = numbers[i];
			while (temp != 0) {
				count++;
				temp /= 10;
			}
			if (count > max) {
				max = count;
				biggerD = numbers[i];
			}
		}
		return biggerD;
	}
}
