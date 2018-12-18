
public class try142 {
	public static void main(String[] args) {

		String image = "hiAll";
		if (!(image.contains(".")) || image.charAt(image.length() - 1) == '.' || image.charAt(0) == '.')
			System.out.println("no");
		else
			System.out.println("yes");
		System.out.println("------------------------------");
		if (color.blue.equals(color.blue))
			System.out.println("yes");
		else
			System.out.println("no");
	}

	enum color {
		blue, red, white, black
	}

}
