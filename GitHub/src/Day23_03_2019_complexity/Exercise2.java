package Day23_03_2019_complexity;

public class Exercise2 {

	public static void main(String[] args) {
		System.out.println(fibo(7L));
	}

	public static long fibo(long number) {
		int n1 = 0, n2 = 1;
		while (number > 0) {

			n1 += n2;
			n2 = n1 - n2;
			number--;
		}

		return n1;
	}
}
