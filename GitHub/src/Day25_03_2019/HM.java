package Day25_03_2019;

public class HM {

	public static void main(String[] args) {
		System.out.println(dual(5, 4));
		System.out.println(divide(20, 4));
		System.out.println(rest(22, 4));
//		System.out.println(sumArr(new int[] { 1, 1, 4, 2, 3 }));
		System.out.println(howMuchChar("cacfgdcasdasdasdcacccbc", 'c'));
	}

	public static int dual(int n1, int n2) {
		if (n1 == 0)
			return 0;

		return n2 - dual(n1 - 1, n2);
	}

	public static double divide(int n1, int n2) {
		if (n1 < n2)
			return 0;
		return 1 + divide(n1 - n2, n2);
	}

	public static int rest(int n1, int n2) {

		if (n1 < n2)
			return n1;
		return rest(n1 - n2, n2);

	}

//	public static int sumArr(int[] arr) {
//		
//		return sumArr(arr[arr.length-1]);
//	}

	public static int howMuchChar(String str, char c) {
		if (str.length() == 0)
			return 0;
		if (str.charAt(str.length() - 1) == c)
			return 1 + howMuchChar(str.substring(0, str.length() - 1), c);
		return howMuchChar(str.substring(0, str.length() - 1), c);
	}
	

}
