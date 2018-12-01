
public class try30 {
	public static void main(String[] args) {
		System.out.println(maxRot(200));
	}

	public static long maxRot(long n) {
		int count = 0, check = (int) n;
		while (check > 0) {
			count++;
			check /= 10;
		}
		long[] arr = new long[count];
		for (int i = 0; i < arr.length; i++) {
			arr[arr.length - 1 - i] = n % 10;
			n /= 10;
		}
		int count2 = 0;
		long sum = 0;
		while (count2 < count - 1) {
			long temp = 0;
			for (int i = count2; i < arr.length - 1; i++) {
				if (i == count2)
					temp = arr[i];
				arr[i] = arr[i + 1];
				if (i == arr.length - 2)
					arr[arr.length - 1] = temp;
			}
			long x=0;
			for (int i = 0; i < arr.length; i++) {
				x *= 10;
				x += arr[i];
			}
			if (sum < x)
				sum = x;
			count2++;
		}

		return sum;
	}

}
