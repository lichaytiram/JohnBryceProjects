package Day23_03_2019_complexity;

public class Exercise8 {

	public static void main(String[] args) {

		numbers(new int[] { 2, 4, 6, 555, 76 }, new int[] { 2, 3, 555, 88 });
	}

	public static void numbers(int[] arr1, int[] arr2) {
		int[] arrResult = new int[100000];
		for (int i = 0; i < arr1.length; i++) {
			arrResult[arr1[i]] += 1;
		}
		for (int i = 0; i < arr2.length; i++) {
			arrResult[arr2[i]] += 1;
		}
		for (int i = 0; i < arrResult.length; i++) {
			if (arrResult[i] >= 2)
				System.out.print(i + " ");
		}
	}
}
