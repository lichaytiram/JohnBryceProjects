
public class try167 {

	public static void main(String[] args) {
		System.out.println(fibRecursive(8));
	}

	public static long fibRecursive(int index) {

		if (index == 0)
			return 0;

		if (index == 1)
			return 1;

		return fibRecursive(index - 1) + fibRecursive(index - 2);
	}

}