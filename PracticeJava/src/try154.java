
public class try154 {

	public static void main(String[] args) {
		System.out.println(solution(9));
	}

	public static int solution(int n) {

		String binary = convertTobinary(n);
		int max = 0, maxTemp = 0;

		while (binary.length() > 0) {
			if (binary.charAt(binary.length() - 1) == '1') {
				if (maxTemp > max)
					max = maxTemp;
				maxTemp = 0;
			} else {
				maxTemp++;
			}
			binary = binary.substring(0, binary.length() - 1);
		}
		return max;

	}

	public static String convertTobinary(int n) {

		String number = "";
		while (n > 0) {

			if (n % 2 != 0)
				number += 1;
			else
				number += 0;

			n /= 2;
		}

		return number;
	}

}
