
public class try91 {
	public static void main(String[] args) {
		System.out.println(getXO("xooXerosX"));
		System.out.println(getXo("xooXerosX"));

	}

	public static boolean getXO(String str) {
		int x = 0, o = 0;
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == 'x')
				x++;
			else if (str.charAt(i) == 'o')
				o++;

		return x == o;
	}

	public static boolean getXo(String str) {
		str = str.toLowerCase();
		return str.replace("x", "").length() == str.replace("o", "").length();
	}
}
