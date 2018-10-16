
public class try34 {
	public static void main(String[] args) {
		String s = "apple rottenBanana rottenapple rottenx";
		String[] arrs = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arrs[i] = String.valueOf(s.charAt(i));
		}
		String[] arr = new String[removeRotten(arrs).length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = String.valueOf(removeRotten(arrs)[i].charAt(0));
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

	public static String[] removeRotten(String[] fruitBasket) {
		String s = "";
		for (int i = 0; i < fruitBasket.length; i++) {
			if (fruitBasket[i].charAt(0) != 'r' || i >= (fruitBasket.length - 6))
				s += fruitBasket[i].charAt(0);
			else {
				while (i < fruitBasket.length - 6) {
					if (fruitBasket[i + 1].charAt(0) == 'o' && fruitBasket[i + 2].charAt(0) == 't'
							&& fruitBasket[i + 3].charAt(0) == 't' && fruitBasket[i + 4].charAt(0) == 'e'
							&& fruitBasket[i + 5].charAt(0) == 'n') {
						i += 5;
					} else
						s += fruitBasket[i].charAt(0);
					break;
				}
			}
		}
		String[] arrs = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arrs[i] = String.valueOf(s.charAt(i));
			if (arrs[i].charAt(0) >= 'A' && arrs[i].charAt(0) <= 'Z') {
				arrs[i] = arrs[i].replace(arrs[i].charAt(0), (char) (arrs[i].charAt(0) + 32));
			}
		}
		return arrs;
	}

}
