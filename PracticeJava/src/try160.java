
public class try160 {

	public static void main(String[] args) {
		System.out.println(per(2123, 3221));

	}

	public static boolean per(int n1, int n2) {

		int[] arr1 = new int[10];
		int[] arr2 = new int[10];

		while (n1 > 0) {
			arr1[n1 % 10] += 1;
			n1 /= 10;
		}
		while (n2 > 0) {
			arr2[n2 % 10] += 1;
			n2 /= 10;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

}
