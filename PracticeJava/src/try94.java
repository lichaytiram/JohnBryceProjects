
public class try94 {
	public static void main(String[] args) {

		System.out.println(findShort("omg hiToAll must play tomorrow!"));
	}

	public static int findShort(String s) {
		int count = 0, countAll = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ')
				count++;
			if (s.charAt(i) == ' ' || i == s.length() - 1) {
				if (count < countAll)
					countAll = count;
				count = 0;
			}
		}
		return countAll;
	}
}
