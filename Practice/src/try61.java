
public class try61 {
	public static void main(String[] args) {
		System.out.println(dashatize(1));
	}

	public static String dashatize(int num) {
		if(num==0)
			return "0";
		int count = countNum(num);
		int[] arr = new int[count];
		inArr(arr, num);
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			boolean inside = false, check = false;
			if (arr[i] % 2 != 0) {
				s += arr[i];
				inside = true;
			}
			if (inside == false) {
				for (int j = i; j < arr.length; j++) {
					if (arr[j] % 2 != 0) {
						i = j;
						check = true;
						break;
					}
					s += arr[j];
					if (j == arr.length - 1)
						i = j;

				}
			}
			if (arr[i] % 2 != 0 && check == true)
				s += "-" + arr[i];
			if (i < arr.length - 1)
				s += "-";

		}
		return s;
	}

	public static void inArr(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			arr[arr.length - 1 - i] = num % 10;
			num /= 10;
		}
	}

	public static int countNum(int num) {
		int count = 0;
		while (num > 0) {
			num /= 10;
			count++;
		}
		return count;
	}

}
