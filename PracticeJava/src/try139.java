
public class try139 {
	public static void main(String[] args) {
		System.out.println(number(new int[][] { { 10, 0 }, { 3, 5 }, { 5, 8 } }));
	}

	public static int number(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][0];
			sum -= arr[i][1];
		}
		return sum;
	}

}
