
public class try54 {
	public static void main(String[] args) {

		double[] arr = { 1, 1, 1, 2, 1, 1 };
		System.out.println(findUniq(arr));

	}

	public static double findUniq(double arr[]) {
		if (arr[0] != arr[1])
			if (arr[1] == arr[2])
				return arr[0];
			else if (arr[0] == arr[2])
				return arr[1];
		double first = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=first)
				return arr[i];
		}
		return -1;
	}
}
