
public class try119 {
	public static void main(String[] args) {
		System.out.println(bumps("______n___n_"));

	}

	public static String bumps(final String road) {
		int sum = 0;
		for (int i = 0; i < road.length(); i++) {
			if (road.charAt(i) == 'n')
				sum++;
			if (sum >= 15)
				return "Car Dead";
		}
		return "Woohoo!";
	}
}
