
public class try81 {
	public static void main(String[] args) {
		int[] arr = { 19, 98, 69, 28, 75, 45, 17, 98, 67 };
		System.out.println(minimumSteps(arr, 464));
	}

	public static int minimumSteps(int[] numbers, int k) {
		int sum = 0, needToReturn = -1;
		while (k > sum) {
			int check = 0;
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] != -1) {
					check = numbers[i];
					break;
				}
			}
			int index = 0;
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] <= check && numbers[i] != -1) {
					check = numbers[i];
					index = i;
				}
			}
			sum += numbers[index];
			numbers[index] = -1;
			needToReturn++;

			int checkAll = -numbers.length, sumAll = 0;
			for (int i = 0; i < numbers.length; i++) {
				sumAll += numbers[i];
			}
			if (checkAll == sumAll)
				break;
		}

		return needToReturn;
	}

}
