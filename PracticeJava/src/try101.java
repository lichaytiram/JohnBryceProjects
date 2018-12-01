
public class try101 {
	public static void main(String[] args) {

		System.out.println(HighAndLow("1 2 -3 4 5"));
	}

	public static String HighAndLow(String numbers) {
		String arr[] = numbers.split(" ");
		int[] arrInt = new int[arr.length];
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = Integer.parseInt(arr[i]);
		}
		int max = Integer.parseInt(arr[0]), min = Integer.parseInt(arr[0]);
		for (int i = 0; i < arr.length; i++)
			if (arrInt[i] > max)
				max = arrInt[i];
			else if (arrInt[i] < min)
				min = arrInt[i];
		return max + " " + min;
	}
}
