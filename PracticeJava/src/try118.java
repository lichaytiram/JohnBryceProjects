
public class try118 {
	public static void main(String[] args) {
		System.out.println(isAscOrder(new int[] { 1, 4, 13, 97, 508, 1047, 20058 }));
	}

	public static boolean isAscOrder(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

}
