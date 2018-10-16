
public class try58 {
	public static void main(String[] args) {

		System.out.println(expandedForm(9805));
	}

	public static String expandedForm(int num) {
		String s = "";
		int numberOfDigits = count(num);
		int digits = (int) (Math.pow(10, numberOfDigits - 1));

		for (int i = 0; i < numberOfDigits; i++) {
			int temp = num;
			if (temp / digits == 0)
				digits /= 10;
			else {
				temp /= digits;
				temp *= digits;
				num -= temp;
				s += temp;
				if (i != numberOfDigits - 1)
					s += " + ";
				digits /= 10;
			}
		}
		if (s.length() > 3)
			if (s.charAt(s.length() - 2) == '+')
				s = s.substring(0, s.length() - 3);
		return s;
	}

	public static int count(int num) {
		int count = 0;
		while (num > 0) {
			count++;
			num /= 10;
		}
		return count;
	}
}
