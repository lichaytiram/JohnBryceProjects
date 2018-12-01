
public class try60 {
	public static void main(String[] args) {
		System.out.println(dashatize(14487421));
	}

	public static String dashatize(int num) {
		String s = "";
		while (num > 9) {
			int temp = num % 10;
			int count = 1;
			while (temp % 2 == 0 && (num / 10) % 2 == 0 && num > 0) {
				num /= 10;
				int tempNew;
				tempNew = (int) Math.pow(10, count) * (num % 10);
				count++;
				temp += tempNew;

			}

			s = "-" + temp + s;
			num /= 10;
		}
		if (num == 0) {
			s = s.substring(1, s.length());
			return s;
		}
		s = num + s;
		return s;
	}
}
