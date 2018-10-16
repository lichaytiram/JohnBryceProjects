
public class try36 {

	public static void main(String[] args) {
		String[] fruitBasket = { "\"apple\", \"rottenBanana\", \"apple\"" };
		for (int i = 0; i < fruitBasket.length; i++) {
			System.out.print(removeRotten(fruitBasket)[i] + " ");
		}
	}

	public static String[] removeRotten(String[] fruitBasket) {
		if (fruitBasket.equals(""))
			return new String[0];

		for (int i = 0; i < fruitBasket.length; i++) {
			if (fruitBasket[i].contains("rotten"))
				fruitBasket[i] = fruitBasket[i].replaceAll("rotten", "").toLowerCase();
		}
		return fruitBasket;
	}

}
