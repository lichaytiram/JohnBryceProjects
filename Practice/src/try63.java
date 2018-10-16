
public class try63 {
	public static void main(String[] args) {
		System.out.println(bowlingPins(new int[] { 8, 4 }));

	}

	public static String bowlingPins(int[] arr) {
		String s = "7 8 9 x\n 4 5 6 \n  2 3  \n   1   ";
		for (int i = 0; i < arr.length; i++) {
			s = s.replaceAll(arr[i] + "", " ");
			if (arr[i] == 10)
				s = s.replaceAll('x' + "", " ");

		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '1' && s.charAt(i) <= '9' || s.charAt(i) == 'x')
				s = s.replace(s.charAt(i), 'I');
		}
		return s;
	}
}
