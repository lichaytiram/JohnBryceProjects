package Day23_03_2019_complexity;

public class Exercise1 {

	public static void main(String[] args) {
		System.out.println(isNotExist(1235589));
	}

	public static String isNotExist(int number) {
		String numbers = "";

		boolean[] booleanArray = new boolean[10];

		while (number > 0) {
			booleanArray[number % 10] = true;
			number /= 10;
		}
		for (int i = 0; i < booleanArray.length; i++) {
			if (!booleanArray[i])
				numbers += i + " ";
		}
		return numbers.trim();
	}

}
